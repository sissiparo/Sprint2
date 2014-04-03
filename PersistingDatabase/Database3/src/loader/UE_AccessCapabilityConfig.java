package loader;

//import persistence.PersistenceUtil;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.AccessCapability;
import entities.UeAccessCapability;
import entities.UeAccesscapabilityPK;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class UE_AccessCapabilityConfig extends SuperConfig {

	public UE_AccessCapabilityConfig() {
		
	}

	@PersistenceContext
    private EntityManager em;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addUeAccessCapability() {

		Workbook workbook = WorkbookSingleton.getWorkbook(workbookFileName);
		Sheet currentSheet = workbook.getSheet(ColumnIndexes.UE__SHEETNO);

		Cell[] row;

		for (int i = 1; i < currentSheet.getRows(); i++) {
			row = currentSheet.getRow(i);

			if (row.length > 0) {

				String concatCapabilities = row[ColumnIndexes.UE_ACCESSCAPABILITY_COLNO]
						.getContents();
				String[] indivCapabilities = concatCapabilities.split(", ");
				for (int j = 0; j < indivCapabilities.length; j++) {
					int accessID = getAccessCapability(indivCapabilities[j]).getAccessID();
							//em.find(AccessCapability.class, indivCapabilities[j]).getAccessID();
					UeAccesscapabilityPK ue_acc = new UeAccesscapabilityPK(
							row[ColumnIndexes.UE_TAC_COLNO].getContents(),
							accessID);
					if(getUEAccessCapability(accessID, row[ColumnIndexes.UE_TAC_COLNO].getContents())==null){
					UeAccessCapability ueac = new UeAccessCapability(ue_acc);
					em.persist(ueac);
					}
				}
			}
		}
	}

    public AccessCapability getAccessCapability(String accessCapability){
    	Query q = em.createQuery("select o from AccessCapability o where o.accessCapability=:accessCapability");
q.setParameter("accessCapability", accessCapability);
    	 List<AccessCapability> listOfAccessCapability = q.getResultList();
    	 if (listOfAccessCapability.size() == 0)
 			return null;
 		else
 			return listOfAccessCapability.get(0);
    	 
    }
    
    public UeAccessCapability getUEAccessCapability(int id, String tac){
    	UeAccesscapabilityPK ueacpk = new UeAccesscapabilityPK(tac, id);
    	Query q = em.createQuery("select o from UeAccessCapability o where id=:id");
q.setParameter("id", ueacpk);
    	 List<UeAccessCapability> listOfAccessCapability = q.getResultList();
    	 if (listOfAccessCapability.size() == 0)
 			return null;
 		else
 			return listOfAccessCapability.get(0);
    	 
    }
    
    
}
