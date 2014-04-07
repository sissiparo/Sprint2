package loader;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import entities.Manufacturer;

@Stateless
@LocalBean
public class ManufacturerConfig extends SuperConfig {

	public ManufacturerConfig() {
		
	}

	 @PersistenceContext
	    private EntityManager em;
	    
	    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addManufacturer() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			if (getManufacturer(row[ColumnIndexes.UE_MANUFACTURER_COLNO]
					.getContents()) == null) {
				Manufacturer manufacturer = new Manufacturer((row[ColumnIndexes.UE_MANUFACTURER_COLNO]
						.getContents()));
				em.persist(manufacturer);
			}
		}
	}

	    public Manufacturer getManufacturer(String manufacturerName){
	    	Query q = em.createQuery("select o from Manufacturer o where o.manufacturerName=:manufacturerName");
  q.setParameter("manufacturerName", manufacturerName);
	    	 List<Manufacturer> listOfManufacturer = q.getResultList();
	    	 if (listOfManufacturer.size() == 0)
	 			return null;
	 		else
	 			return listOfManufacturer.get(0);
	    	 
	    }

}
