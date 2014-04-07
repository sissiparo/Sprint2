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
import entities.UEModel;
import entities.UserEquipment;

@Stateless
@LocalBean
public class UserEquipmentConfig extends SuperConfig {
	
	private Manufacturer manufacturer;
	private UEModel model;

	public UserEquipmentConfig() {
		
	}

	@PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addUserEquipment() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				String manufacturerName = row[ColumnIndexes.UE_MANUFACTURER_COLNO]
						.getContents();
				
				manufacturer = getManufacturer(manufacturerName);
				//int manufacturerId = manufacturer.getManufacturerID();
				
				
				model = getUEModel(row[ColumnIndexes.UE_MODEL_COLNO].getContents());
				
				//int modelID = model.getModelId();

				if(em.find(UserEquipment.class, (row[ColumnIndexes.UE_TAC_COLNO].getContents()))==null){
					UserEquipment userEquipment = new UserEquipment(
						(row[ColumnIndexes.UE_TAC_COLNO].getContents()),
						manufacturer, model,
						row[ColumnIndexes.UE_UETYPE_COLNO].getContents(),
						row[ColumnIndexes.UE_OS_COLNO].getContents(),
						row[ColumnIndexes.UE_INPUTMODE_COLNO].getContents());
				em.persist(userEquipment);
				}

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
    
    public UEModel getUEModel(String modelName){
    	Query q = em.createQuery("select o from UEModel o where o.modelName=:modelName");
q.setParameter("modelName", modelName);
    	 List<UEModel> listOfUEModels = q.getResultList();
    	 if (listOfUEModels.size() == 0)
 			return null;
 		else
 			return listOfUEModels.get(0);
    	 
    }
}
