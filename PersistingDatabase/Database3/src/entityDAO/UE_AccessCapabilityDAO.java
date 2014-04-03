package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

//import entities.UE_AccessCapability;
import entities.UeAccessCapability;

@Stateless
@LocalBean
public class UE_AccessCapabilityDAO {

    @PersistenceContext
    private EntityManager em;
    
    public UeAccessCapability getUE_AccessCapability(String userEquipID) {
        return em.find(UeAccessCapability.class, userEquipID);
    }
    
    public List<UeAccessCapability> getAllUE_AccessCapability(){
	    TypedQuery<UeAccessCapability> q = em.createQuery("select o from UE_AccessCapability o", UeAccessCapability.class);
	    List<UeAccessCapability> listOfUE_AccessCapability = q.getResultList();
	    return listOfUE_AccessCapability;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addUE_AccessCapabilitys(List<UeAccessCapability> ue_accessCapabilities) {
        for (UeAccessCapability ue_accessCapability : ue_accessCapabilities) {
            em.persist(ue_accessCapability);
        }
    }
    
}
