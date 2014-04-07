package loader;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Country;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class LoadData extends SuperConfig{
	
    @PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addCountries(){
    	
    	Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.MCCMNC__SHEETNO);
    	
		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			if (row.length > 0) {
				int mcc = Integer.parseInt(row[ColumnIndexes.MCCMNC_MCC_COLNO]
						.getContents());
				
					Country country = new Country(mcc + 1,
							row[ColumnIndexes.MCCMNC_COUNTRY_COLNO]
									.getContents());
				em.persist(country);
			}
		}
    }

}
