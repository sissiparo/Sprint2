package loader;

//import persistence.PersistenceUtil;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.EventCause;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class EventCauseConfig extends SuperConfig {

	@PersistenceContext
    private EntityManager em;
	
	public EventCauseConfig() {
		
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addEventCause() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook
				.getSheet(ColumnIndexes.EVENTCAUSE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				EventCause eventCause = new EventCause(
						Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_CAUSECODE_COLNO]
								.getContents()),
						Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_EVENTID_COLNO]
								.getContents()),
						row[ColumnIndexes.EVENTCAUSE_DESCRIPTION_COLNO]
								.getContents());
				if(em.find(EventCause.class, Integer.parseInt(row[ColumnIndexes.EVENTCAUSE_CAUSECODE_COLNO]
						.getContents()))==null)
					em.persist(eventCause);
					

			}

		}
//	}

//	public void createEventCause(int causeID, int eventID,
//			String causeDescription) {
//		EventCause eventCause = new EventCause(causeID, eventID,
//				causeDescription);
//		PersistenceUtil.persist(eventCause);
		}

}
