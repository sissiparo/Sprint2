package loader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.AccessCapability;
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

//import persistence.PersistenceUtil;
@Stateless
@LocalBean
public class BaseDataAndCellTableConfig extends SuperConfig {

	public String baseDate, eventID, failureClassID, TAC, mccID, mncID, cellID,
			duration, causeCode, neVersion, imsi, hier3_ID, hier32_ID,
			hier321_ID;
	public BaseData baseData;
	public CellTable cellTable;
	public int eventCauseID, mccmncID;
	public static ArrayList<Integer> invalidColumns = new ArrayList();

	public EventCause eventcause;
	public MCCMNC mccmnc;
	public CellTable celltable;
	public Failure failure;
	public UserEquipment userequipment;

	SimpleDateFormat sdf = new SimpleDateFormat("");
	static java.util.Date time = new java.util.Date();
	java.sql.Timestamp sqlDate = new java.sql.Timestamp(time.getTime());

	public BaseDataAndCellTableConfig() {

	}

	public void getObjects() {

		eventcause = getEventCause(Integer.parseInt(eventID),
				Integer.parseInt(causeCode));

		// em.find(EventCause.class, Integer.parseInt(eventID));
		// PersistenceUtil.findEventID(Integer.parseInt(eventID));
		mccmnc = getMCCMNC(Integer.parseInt(mncID),
				em.find(Country.class, Integer.parseInt(mccID)));
		// em.find(MCCMNC.class, Integer.parseInt(mncID));
		// PersistenceUtil.findMCCMNCByName(Integer.parseInt(mncID));
		celltable = em.find(CellTable.class, Integer.parseInt(cellID));
		// PersistenceUtil.findByCellID(Integer.parseInt(cellID));
		failure = em.find(Failure.class, Integer.parseInt(failureClassID));
		// PersistenceUtil.findFailureCode(Integer.parseInt(failureClassID));
		userequipment = em.find(UserEquipment.class, TAC);
		// PersistenceUtil.findTAC(TAC);

	}

	public Country getCountry(int mcc) {
		Query q = em.createQuery("select o from Country o where o.mcc=:mcc");
		q.setParameter("mcc", mcc);
		List<Country> listOfCountry = q.getResultList();
		if (listOfCountry.size() == 0)
			return null;
		else
			return listOfCountry.get(0);

	}

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addBaseDataAndCellTableConfig() {

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
					hier3_ID = row[ColumnIndexes.BASEDATA_HIER3ID_COLNO]
							.getContents();
					hier32_ID = row[ColumnIndexes.BASEDATA_HIER32ID_COLNO]
							.getContents();
					hier321_ID = row[ColumnIndexes.BASEDATA_HIER321ID_COLNO]
							.getContents();
					mccID = row[ColumnIndexes.BASEDATA_MARKET_COLNO]
							.getContents();
					mncID = row[ColumnIndexes.BASEDATA_OPERATOR_COLNO]
							.getContents();
					causeCode = row[ColumnIndexes.BASEDATA_CAUSECODE_COLNO]
							.getContents();

					String[] rowOfStrings = { baseDate, eventID,
							failureClassID, TAC, mccID, mncID, cellID,
							duration, causeCode, neVersion, imsi, hier3_ID,
							hier32_ID, hier321_ID };

					// if (checkRowIsValid(rowOfStrings)) {
					getObjects();
					// eventCauseID = getEventCause(
					// Integer.parseInt(eventID),
					// Integer.parseInt(causeCode))
					// .getEventcauseCode();

					mccmncID = getMCCMNC(Integer.parseInt(mncID),
							em.find(Country.class, Integer.parseInt(mccID)))
							.getMccmncID();

					

					try {
						if (eventcause != null) {
							baseData = new BaseData(eventcause, mccmnc,
									celltable, Integer.parseInt(duration),
									imsi, failure, userequipment, neVersion,
									parseDate(baseDate));

							em.persist(baseData);
						}

					} catch (NumberFormatException e) {
						System.out
								.println("Check has been performed already so should not throw");
						e.printStackTrace();
					} catch (ParseException e) {
						System.out
								.println("Check has been performed already so should not throw");
						e.printStackTrace();
					}
				}

				// }

			}

		} catch (Exception e) {
			System.err.println(e.toString());
		}

	}

	public EventCause getEventCause(int eventID, int causeCode) {
		Query q = em
				.createQuery("select o from EventCause o where o.eventID=:eventID and o.causeCode=:causeCode");
		q.setParameter("eventID", eventID);
		q.setParameter("causeCode", causeCode);
		List<EventCause> listOfEventCause = q.getResultList();
		if (listOfEventCause.size() == 0)
			return null;
		else
			return listOfEventCause.get(0);

	}

	public MCCMNC getMCCMNC(int mnc, Country country) {
		Query q = em
				.createQuery("select o from MCCMNC o where o.mnc=:mnc and o.country=:country");
		q.setParameter("mnc", mnc);
		q.setParameter("country", country);
		List<MCCMNC> listOfMCCMNC = q.getResultList();
		if (listOfMCCMNC.size() == 0)
			return null;
		else
			return listOfMCCMNC.get(0);

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

	// public static boolean checkRowIsValid(String [] rowOfCells){
	//
	// if(checkDateFormat(rowOfCells[0])){
	// if (checkEventIdAndCauseCode(rowOfCells[1], rowOfCells[8])){
	// if (checkFailureClass(rowOfCells[2])){
	// if(checkTAC(rowOfCells[3])){
	// if(checkMCCAndMNC(rowOfCells[4], rowOfCells[5])){
	// if(checkCellIdAndDuration(rowOfCells[6],rowOfCells[7])){
	// if(checkIMSI(rowOfCells[10])){
	// if(checkHIERIDs(rowOfCells[11],rowOfCells[12],rowOfCells[13])){
	// return true;
	// }
	// }
	// }
	// }
	// }
	// }
	// }
	//
	// }
	// storeRowError(rowOfCells);
	// return false;
	// }

	public static boolean checkHIERIDs(String HIERID3, String HIERID32,
			String HIERID321) {
		if (((HIERID3.matches("[0-9]+") && (HIERID3.length() > 15 && HIERID3
				.length() <= 19))
				&& (HIERID32.matches("[0-9]+") && (HIERID32.length() > 15 && HIERID32
						.length() <= 19)) && (HIERID321.matches("[0-9]+") && (HIERID321
				.length() > 15 && HIERID321.length() <= 19)))) {
			return true;
		}
		if (!HIERID3.matches("[0-9]+")
				|| (HIERID3.length() != 19 && HIERID3.length() != 18)) {
			invalidColumns.add(11);
		}
		if (!HIERID32.matches("[0-9]+")
				|| (HIERID32.length() != 19 && HIERID32.length() != 18)) {
			invalidColumns.add(12);
		}
		if (!HIERID321.matches("[0-9]+")
				|| (HIERID32.length() != 19 && HIERID32.length() != 18)) {
			invalidColumns.add(13);
		}
		System.out.println("Broke at checkHIERIDs: " + HIERID3 + " " + HIERID32
				+ " " + HIERID321);
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

	// public static boolean checkMCCAndMNC(String mccColumnValue, String
	// mncColumnValue) {
	//
	// if(PersistenceUtil.findCountry(Integer.parseInt(mccColumnValue))==null){
	// invalidColumns.add(4);
	// }
	//
	// if(PersistenceUtil.findMCCMNCByName(Integer.parseInt(mncColumnValue))!=null){
	// return true;
	// }else{
	// invalidColumns.add(5);
	// }
	//
	// System.out.println("Broke at MCC-MNC: "+mccColumnValue+" "+mncColumnValue);
	// return false;
	// }
	//
	// public static boolean checkTAC(String tacColumnValue) {
	//
	// if(PersistenceUtil.findTAC(tacColumnValue)!=null){
	// return true;
	// }else{
	// invalidColumns.add(3);
	// System.out.println("Broke at TAC: "+tacColumnValue);
	// return false;
	// }
	// }
	//
	// public static boolean checkFailureClass(String failureClassColumnValue) {
	// try{
	// int failureClassAsInt=Integer.parseInt(failureClassColumnValue);
	//
	// if(PersistenceUtil.findFailureCode(failureClassAsInt)!=null){
	//
	// return true;
	//
	// }else{
	// invalidColumns.add(2);
	// System.out.println("Broke at Failure Class: "+ failureClassColumnValue);
	// return false;
	// }
	// }catch(NumberFormatException e){
	// invalidColumns.add(2);
	// return false;
	// }
	// }
	//
	// public static boolean checkEventIdAndCauseCode(String eventIdColumnValue,
	// String causeCodeColumnValue) {
	//
	// try{
	// int eventIdAsInt=Integer.parseInt(eventIdColumnValue);
	// int causeCodeAsInt=Integer.parseInt(causeCodeColumnValue);
	//
	// if(PersistenceUtil.findEventID(eventIdAsInt)==null){
	//
	// invalidColumns.add(1);
	// }
	// else{
	//
	// }
	//
	//
	// if(PersistenceUtil.findEventIDAndCauseCode(eventIdAsInt,causeCodeAsInt)!=null){
	//
	// return true;
	//
	// }else{
	// invalidColumns.add(8);
	// return false;
	// }
	// }
	// catch(NumberFormatException e){
	// if(!eventIdColumnValue.matches("[0-9]+")){
	// invalidColumns.add(1);
	// }else{
	// invalidColumns.add(8);
	// }
	// return false;
	// }
	// }
	//
	//

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
			pw = new PrintWriter(
					new FileWriter(
							"C:/Users/Mobile/Desktop/Workspace/WS10/errorLog.csv",
							true));
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

	// public void storeData(){
	//
	//
	// if(PersistenceUtil.findByCellID(Integer.parseInt(cellID))==null){
	// cellTable = new CellTable(
	// Integer.parseInt(cellID), hier3_ID,
	// hier32_ID, hier321_ID);
	// PersistenceUtil.persist(cellTable);}
	// getObjects();
	//
	// try {
	// baseData = new BaseData(eventcause,
	// mccmnc, celltable,
	// Integer.parseInt(duration), imsi,
	// failure, userequipment, neVersion,
	// parseDate(baseDate));
	//
	// PersistenceUtil.persist(baseData);
	//
	// } catch (NumberFormatException e) {
	// System.out.println("Check has been performed already so should not throw");
	// e.printStackTrace();
	// } catch (ParseException e) {
	// System.out.println("Check has been performed already so should not throw");
	// e.printStackTrace();
	// }
	//
	// }

}
