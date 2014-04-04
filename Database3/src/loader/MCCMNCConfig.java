package loader;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import entities.Country;
import entities.MCCMNC;
import entityDAO.CountryDAO;
import entityWS.*;

@Stateless
@LocalBean
public class MCCMNCConfig extends SuperConfig {

	@PersistenceContext
    private EntityManager em;
	
	public MCCMNCConfig() {
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addMCCMNC() {
	

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.MCCMNC__SHEETNO);

		Cell[] row;

		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				MCCMNC mccmnc = new MCCMNC(em.find(Country.class, Integer.parseInt(row[ColumnIndexes.MCCMNC_MCC_COLNO]
						.getContents())), Integer.parseInt(row[ColumnIndexes.MCCMNC_MNC_COLNO]
								.getContents()), row[ColumnIndexes.MCCMNC_OPERATOR_COLNO].getContents());
				if(em.find(MCCMNC.class, Integer.parseInt(row[ColumnIndexes.MCCMNC_MCC_COLNO]
						.getContents()))==null)
				em.persist(mccmnc);
				
			}
		}

	}

}
