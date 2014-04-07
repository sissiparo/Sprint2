package entityDAO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.BaseData;
import entities.Failure;

@Stateless
@LocalBean
public class FailureDAO {

    @PersistenceContext
    private EntityManager em;
    
    public Failure getFailure(int failureID) {
        return em.find(Failure.class, failureID);
    }
    
    public List<String> getAllFailure(){
	    Query q = em.createQuery("select failureID from Failure");
    	List<Failure> listOfFailure = q.getResultList();
    	ArrayList<String> fids = new ArrayList<String>();
    	for (Failure f:listOfFailure){
    		//System.out.println("failuure:"+ f);
    		fids.add(""+f.getFailureID());
    	}
		//return listOfFailure;
    	return fids;
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addFailures(List<Failure> failures) {
        for (Failure failure : failures) {
            em.persist(failure);
        }
    }
    
}
