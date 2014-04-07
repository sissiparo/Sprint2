package loader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import entities.BaseData;
import entities.CellTable;
import entities.Country;
import entities.EventCause;
import entities.Failure;
import entities.MCCMNC;
import entities.UserEquipment;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class BaseDataAndCellTableConfig extends SuperConfig {

	public String baseDate, eventID, failureClassID, TAC, mccID, mncID, cellID,
			duration, causeCode, neVersion, imsi;
	public BaseData baseData;
	public int eventCauseID;
	public static ArrayList<Integer> invalidColumns = new ArrayList();

	public EventCause eventcause;
	public MCCMNC mccmnc;
	public CellTable celltable;
	public Failure failure;
	public Country country;
	public UserEquipment userequipment;
	public List<BaseData> bds = new ArrayList<BaseData>();
	public List<EventCause> eventC;
	public List<MCCMNC> mcnC;
	public List<CellTable> ctC;
	public List<UserEquipment> ueC;
	public List<Failure> failC;
	public List<Country> countryC;

	SimpleDateFormat sdf = new SimpleDateFormat("");
	static java.util.Date time = new java.util.Date();
	java.sql.Timestamp sqlDate = new java.sql.Timestamp(time.getTime());

	public BaseDataAndCellTableConfig() {

	}

	@PersistenceContext
	private EntityManager em;

	public void addBaseDataAndCellTableConfig() {

		eventC = getAllEventCause();
		mcnC = getAllMCCMNC();
		ctC = getAllCellTable();
		ueC = getAllUserEquipment();
		failC = getAllFailure();

		try {

			Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
			Sheet currentSheet = workbook
					.getSheet(ColumnIndexes.BASEDATA__SHEETNO);

			Cell[] row;

			for (int i = 1; i < currentSheet.getRows(); i++) {
				row = currentSheet.getRow(i);
				if (row.length > 0) {

					cellID = row[ColumnIndexes.BASEDATA_CELLID_COLNO]
							.getContents();
					eventID = row[ColumnIndexes.BASEDATA_EVENTID_COLNO]
							.getContents();
					duration = row[ColumnIndexes.BASEDATA_DURATION_COLNO]
							.getContents();
					imsi = row[ColumnIndexes.BASEDATA_IMSI_COLNO].getContents();
					failureClassID = row[ColumnIndexes.BASEDATA_FAILURECLASS_COLNO]
							.getContents();
					TAC = row[ColumnIndexes.BASEDATA_UETYPE_COLNO]
							.getContents();
					neVersion = row[ColumnIndexes.BASEDATA_NEVERSION_COLNO]
							.getContents();
					baseDate = row[ColumnIndexes.BASEDATA_DATE_COLNO]
							.getContents();
					mccID = row[ColumnIndexes.BASEDATA_MARKET_COLNO]
							.getContents();
					mncID = row[ColumnIndexes.BASEDATA_OPERATOR_COLNO]
							.getContents();
					causeCode = row[ColumnIndexes.BASEDATA_CAUSECODE_COLNO]
							.getContents();

					String[] rowOfStrings = { baseDate, eventID,
							failureClassID, TAC, mccID, mncID, cellID,
							duration, causeCode, neVersion, imsi};

					getObjects();

					if (checkRowIsValid(rowOfStrings)) {
						if (eventcause != null && mccmnc != null
								&& celltable != null && failure != null
								&& userequipment != null) {

							try {

								baseData = new BaseData(eventcause, mccmnc,
										celltable, Integer.parseInt(duration),
										imsi, failure, userequipment,
										neVersion, parseDate(baseDate));

								bds.add(baseData);

							} catch (NumberFormatException e) {
								System.out
										.println("Check has been performed already so should not throw");
								e.printStackTrace();
							} catch (ParseException e) {
								System.out
										.println("Check has been performed already so should not throw");
								e.printStackTrace();
							}
						} else {
							storeRowError(rowOfStrings);
						}
					}

				}
			}
			addBaseDatas(bds);

		} catch (Exception e) {
			System.err.println(e.toString());
		}

	}

	public void addBaseDatas(List<BaseData> baseDatas) {
		int i = 0;
		for (BaseData baseData : baseDatas) {

			em.persist(baseData);

			if (++i % 100 == 0) {
				em.flush();
				em.clear();
			}

		}
		bds.clear();

	}

	public EventCause getEventCauseByID() {

		for (EventCause ec : eventC) {
			if (ec.getCauseCode() == Integer.parseInt(causeCode)
					&& ec.getEventID() == Integer.parseInt(eventID)) {
				return ec;
			}

		}

		return null;

	}

	public UserEquipment getUserEquipmentByID() {

		for (UserEquipment uec : ueC) {
			if (uec.getTac().equals(TAC)) {
				return uec;
			}

		}

		return null;

	}

	public Failure getFailureByID() {

		for (Failure fails : failC) {
			if (fails.getFailureID() == Integer.parseInt(failureClassID)) {
				return fails;
			}

		}

		return null;

	}

	public CellTable getCellTableByID() {

		for (CellTable cellt : ctC) {
			if (cellt.getCellID() == Integer.parseInt(cellID)) {
				return cellt;
			}

		}

		return null;

	}

	public MCCMNC getMCCMNCByID() {

		for (MCCMNC mc : mcnC) {
			if (mc.getCountry().getMcc() == Integer.parseInt(mccID)
					&& mc.getMnc() == Integer.parseInt(mncID)) {
				return mc;
			}

		}

		return null;

	}

	public void getObjects() {

		eventcause = getEventCauseByID();
		mccmnc = getMCCMNCByID();
		celltable = getCellTableByID();
		failure = getFailureByID();
		userequipment = getUserEquipmentByID();

	}

	public List<EventCause> getAllEventCause() {
		Query q = em.createQuery("from EventCause");
		List<EventCause> listOfEventCause = q.getResultList();
		return listOfEventCause;
	}

	public List<CellTable> getAllCellTable() {
		Query q = em.createQuery("from CellTable");
		List<CellTable> listOfCellTable = q.getResultList();
		return listOfCellTable;
	}

	public List<Failure> getAllFailure() {
		Query q = em.createQuery("from Failure");
		List<Failure> listOfFailure = q.getResultList();
		return listOfFailure;
	}

	public List<UserEquipment> getAllUserEquipment() {
		Query q = em.createQuery("from UserEquipment");
		List<UserEquipment> listOfUserEquipment = q.getResultList();
		return listOfUserEquipment;
	}

	public List<MCCMNC> getAllMCCMNC() {
		Query q = em.createQuery("from MCCMNC");
		List<MCCMNC> listOfMCCMNC = q.getResultList();
		return listOfMCCMNC;
	}

	public static java.sql.Timestamp parseDate(String dateSample)
			throws ParseException {

		String oldFormat = "M/dd/yy HH:mm";
		String newFormat = "yyyy/MM/dd HH:mm";

		SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
		SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);
		String nda = "";

		try {
			nda = sdf2.format(sdf1.parse(dateSample));
		} catch (ParseException e) {
			return null;
		}

		java.util.Date date = sdf2.parse(nda);
		java.sql.Timestamp sql = new java.sql.Timestamp(date.getTime());

		return sql;

	}

	public static boolean checkRowIsValid(String[] rowOfCells) {

		if (checkDateFormat(rowOfCells[0])) {
			if (checkCellIdAndDuration(rowOfCells[6], rowOfCells[7])) {
				if (checkIMSI(rowOfCells[10])) {
					
						return true;
					
				}
			}
		}

		storeRowError(rowOfCells);
		return false;
	}


	public static boolean checkIMSI(String imsiColumnValue) {
		if (imsiColumnValue.length() == 15 && imsiColumnValue.matches("[0-9]+")) {
			return true;
		}
		System.out.println("Broke at IMSI: " + imsiColumnValue);
		invalidColumns.add(10);
		return false;
	}

	public static boolean checkCellIdAndDuration(String cellIdColumnValue,
			String durationColumnValue) {

		if (!cellIdColumnValue.matches("[0-9]+")) {
			invalidColumns.add(6);
			System.out.println("Broke at CellID: " + cellIdColumnValue);
			return false;
		}
		if (!durationColumnValue.matches("[0-9]+")) {
			invalidColumns.add(7);
			System.out.println("Broke at durationColumnValue: "
					+ durationColumnValue);
			return false;
		}
		return true;
	}

	public static boolean checkDateFormat(String dateColumnValue) {

		java.sql.Timestamp dateToCheck;
		try {
			dateToCheck = parseDate(dateColumnValue);
			if (dateToCheck != null && time.after(dateToCheck)) {
				return true;
			}
		} catch (ParseException e) {
			invalidColumns.add(0);
			return false;
		}
		invalidColumns.add(0);
		return false;
	}

	public static void storeRowError(String[] rowRemoved) {

		PrintWriter pw;
		try {
			pw = new PrintWriter(new FileWriter(
					"/home/group5/workspace/Group5/errorLog.csv", true));
			for (int i = 0; i < rowRemoved.length; i++) {
				pw.write(rowRemoved[i] + ", ");
			}
			pw.println();

			pw.close();
		} catch (IOException e) {
			System.out.println("Error whilst updating error log: "
					+ e.getMessage());
		}
	}

}