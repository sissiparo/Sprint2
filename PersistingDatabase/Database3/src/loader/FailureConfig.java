package loader;

//import persistence.PersistenceUtil;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Failure;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class FailureConfig extends SuperConfig {

	public FailureConfig() {
		
	}

	@PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addFailures() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook
				.getSheet(ColumnIndexes.FAILURECLASS__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				Failure failure = new Failure(
						Integer.parseInt(row[ColumnIndexes.FAILURECLASS_FAILURECLASS_COLNO]
								.getContents()),
						row[ColumnIndexes.FAILURECLASS_DESCRIPTION_COLNO]
								.getContents());
				if(em.find(Failure.class, Integer.parseInt(row[ColumnIndexes.FAILURECLASS_FAILURECLASS_COLNO]
						.getContents()))==null)
				em.persist(failure);
			}
		}
	}

//	public void createFailure(int failureID, String failureDescription) {
//		Failure failure = new Failure(failureID, failureDescription);
//		//PersistenceUtil.persist(failure);
//	}

}
