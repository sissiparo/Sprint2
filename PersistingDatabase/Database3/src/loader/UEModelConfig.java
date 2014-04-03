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
import entities.AccessCapability;
//import persistence.PersistenceUtil;
import entities.UEModel;

@Stateless
@LocalBean
public class UEModelConfig extends SuperConfig {

	public UEModelConfig() {
	}

	@PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addUEModel() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;
		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);
			if (getUEModel(row[ColumnIndexes.UE_MODEL_COLNO]
					.getContents()) == null) {
				UEModel ueModel = new UEModel((row[ColumnIndexes.UE_MODEL_COLNO].getContents()));
				em.persist(ueModel);
			}
		}
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
    
//	public void createUEModel(String modelName) {
//
//		UEModel ueModel = new UEModel(modelName);
//		PersistenceUtil.persist(ueModel);
//	}

}
