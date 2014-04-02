package entityDAO;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.AccessCapability;

//@Stateless
//@LocalBean
@Default
public class JPAAccessCapabilityDAO {

	@PersistenceContext
	private EntityManager em;

	/*@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addAccessCapability(String accessCapability) {
		
			em.persist(accessCapability);
		
	}*/
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addAccessCapability(AccessCapability accessCapability) {
		Query query=em.createQuery("from AccessCapability");
		List<AccessCapability> capabilities=query.getResultList();
		if (!capabilities.contains(accessCapability))
			em.persist(accessCapability);
		
	}
	
	public AccessCapability getAccessCapabilityByName(String accessCapability) {
		Query q = em.createQuery("from AccessCapability o where o.accessCapability= :accessCapability");
		q.setParameter("accessCapability", accessCapability);
		List<AccessCapability> listOfAccessCapability = q.getResultList();
		//if (listOfAccessCapability.size() == 0)
		//	return null;
		//else
			return listOfAccessCapability.get(0);
	}
	
	public Collection<AccessCapability> getAllAccessCapability(){
		Query q = em.createQuery("from AccessCapability");
		List<AccessCapability> listOfAccessCapability = q.getResultList();
		return listOfAccessCapability;
	}
	
	
	
	
	/*public AccessCapability getAccessCapability(int accessID) {
		return em.find(AccessCapability.class, accessID);
	}


	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addAccessCapabilitys(List<AccessCapability> accessCapabilitys) {
		for (AccessCapability accessCapability : accessCapabilitys) {
			em.persist(accessCapability);
		}
	}*/
	
	

}
