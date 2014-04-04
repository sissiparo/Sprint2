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
public class CellTableConfig extends SuperConfig {

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

	public CellTableConfig() {

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
					//getObjects();
					// eventCauseID = getEventCause(
					// Integer.parseInt(eventID),
					// Integer.parseInt(causeCode))
					// .getEventcauseCode();

					mccmncID = getMCCMNC(Integer.parseInt(mncID),
							em.find(Country.class, Integer.parseInt(mccID)))
							.getMccmncID();

					if (em.find(CellTable.class, Integer.parseInt(cellID)) == null) {
						cellTable = new CellTable(Integer.parseInt(cellID),
								hier3_ID, hier32_ID, hier321_ID);
						em.persist(cellTable);
					}

					
				}


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


}
