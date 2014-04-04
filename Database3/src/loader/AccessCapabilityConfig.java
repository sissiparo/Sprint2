package loader;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import javax.persistence.Query;
import javax.persistence.TypedQuery;


//import persistence.PersistenceUtil;
import entities.AccessCapability;
import entities.Country;
import entityDAO.AccessCapabilityDAO;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

@Stateless
@LocalBean
public class AccessCapabilityConfig extends SuperConfig {

	public AccessCapabilityConfig() {
		
	}

	 @PersistenceContext
	    private EntityManager em;
	    
	    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addAccessCapability() {
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
					//if (em.find(AccessCapability.class, indivCapabilities[j]) == null) {
					if(getAccessCapability(indivCapabilities[j])==null){
					//System.out.println(getAllAccessCapability().size());
						AccessCapability accessCapability = new AccessCapability(indivCapabilities[j]);
					em.persist(accessCapability);
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
	    

//	public void createAccessCapability(String accessCapabilityString) {
//		AccessCapability accessCapability = new AccessCapability(
//				accessCapabilityString);
//		PersistenceUtil.persist(accessCapability);
//	}

}
