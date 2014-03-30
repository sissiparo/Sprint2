package entityDAO;

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

@Stateless
@LocalBean
public class BaseDataDAO {

    @PersistenceContext
    private EntityManager em;
    
    public BaseData getBaseData(int baseDataID) {
        return em.find(BaseData.class, baseDataID);
    }
    
    public List<BaseData> getAllBaseData(){
//	    TypedQuery<BaseData> q = em.createQuery("select o from BaseData o", BaseData.class);
	    Query q = em.createQuery("select o from BaseData o");
	    List<BaseData> listOfBaseData = q.setMaxResults(10).getResultList();
	    return listOfBaseData;
    }
    
    public List<BaseData> getImsiBaseData(){
    	Query q = em.createQuery("select imsi from BaseData");
    	List<BaseData> listOfBaseData = q.setMaxResults(10).getResultList();
		return listOfBaseData;

    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void addBaseDatas(List<BaseData> baseDatas) {
        for (BaseData baseData : baseDatas) {
            em.persist(baseData);
        }
    }
    
    public List<BaseData> userStory4(String imsi){
    	Query q = em.createQuery("select imsi, eventcause.eventID, eventcause.causeCode from BaseData"
    			+ " where imsi=" + imsi);
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;

    }
    
    public List<BaseData> userStory6(String imsi){
    	Query q = em.createQuery("SELECT b.imsi, b.eventcause.eventID, b.eventcause.eventcauseCode,"
    			+ " b.eventcause.causeCode, b.eventcause.causeDescription FROM BaseData b where imsi=" + imsi
    			+ " GROUP BY b.eventcause.causeCode");
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;

    }
    
    
}
