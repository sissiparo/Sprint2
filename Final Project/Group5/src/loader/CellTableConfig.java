package loader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.CellTable;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

//import persistence.PersistenceUtil;
@Stateless
@LocalBean
public class CellTableConfig extends SuperConfig {

	public String cellID, hier3_ID, hier32_ID, hier321_ID;
	public CellTable cellTable;

	public CellTableConfig() {

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
					hier3_ID = row[ColumnIndexes.BASEDATA_HIER3ID_COLNO]
							.getContents();
					hier32_ID = row[ColumnIndexes.BASEDATA_HIER32ID_COLNO]
							.getContents();
					hier321_ID = row[ColumnIndexes.BASEDATA_HIER321ID_COLNO]
							.getContents();

					String[] rowOfStrings = { hier3_ID, hier32_ID, hier321_ID };

					if (checkRowIsValid(rowOfStrings)) {

						if (em.find(CellTable.class, Integer.parseInt(cellID)) == null) {
							cellTable = new CellTable(Integer.parseInt(cellID),
									hier3_ID, hier32_ID, hier321_ID);
							em.persist(cellTable);
						}

					}
				}

			}

		} catch (Exception e) {
			System.err.println(e.toString());
		}

	}

	public static boolean checkRowIsValid(String[] rowOfCells) {

		if (checkHIERIDs(rowOfCells[0], rowOfCells[1], rowOfCells[2])) {
			return true;
		}
		storeRowError(rowOfCells);
		return false;
	}

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
		}
		if (!HIERID32.matches("[0-9]+")
				|| (HIERID32.length() != 19 && HIERID32.length() != 18)) {
		}
		if (!HIERID321.matches("[0-9]+")
				|| (HIERID32.length() != 19 && HIERID32.length() != 18)) {
		}
		System.out.println("Broke at checkHIERIDs: " + HIERID3 + " " + HIERID32
				+ " " + HIERID321);
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