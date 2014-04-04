package entityDAO;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import entities.BaseData;
import entities.Failure;

import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
    	Query q = em.createQuery("select baseDate, eventcause.eventID, eventcause.causeCode, eventcause.causeDescription from BaseData"
    			+ " where imsi=" + imsi);
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }
    
    public List<BaseData> userStory5(String imsi, String startDate, String endDate){
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	
    	startDate=startDate.concat(" 00:00:00");
    	Calendar calStart=Calendar.getInstance();
    	try {
			calStart.setTime(sdf.parse(startDate));
		} catch (ParseException e) {
			System.out.println("Start date not parsing with mins:"+startDate);
			e.printStackTrace();
		}
    	
    	endDate=endDate.concat(" 00:00:00");
    	System.out.println(endDate);
    	Calendar calEnd=Calendar.getInstance();
    	try {
			calEnd.setTime(sdf.parse(endDate));
		} catch (ParseException e) {
			System.out.println("End date not parsing with mins:"+endDate);
			e.printStackTrace();
		}
   
    	Query q = em.createQuery("select count(*) from BaseData where BaseDate >= :startDate and BaseDate <= :endDate and imsi="+ imsi)
    	.setParameter("startDate", calStart, TemporalType.DATE)
        .setParameter("endDate", calEnd, TemporalType.DATE);
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }
    
    
    public List<BaseData> userStory6(String imsi){
    	Query q = em.createQuery("SELECT imsi, eventcause.eventID, eventcause.eventcauseCode,"
    			+ " eventcause.causeCode, eventcause.causeDescription FROM BaseData where imsi=" + imsi
    			+ " GROUP BY eventcause.causeCode");
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }

    
  public List<BaseData> userStory7(String startDate, String endDate){
	 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 	
	 	
	 	startDate=startDate.concat(" 00:00:00");
	 	Calendar calStart=Calendar.getInstance();
	 	try {
				calStart.setTime(sdf.parse(startDate));
			} catch (ParseException e) {
				System.out.println("Start date not parsing with mins:"+startDate);
				e.printStackTrace();
			}
	 	
	 	endDate=endDate.concat(" 00:00:00");
	 	System.out.println(endDate);
	 	Calendar calEnd=Calendar.getInstance();
	 	try {
				calEnd.setTime(sdf.parse(endDate));
			} catch (ParseException e) {
				System.out.println("End date not parsing with mins:"+endDate);
				e.printStackTrace();
			}

    	Query q = em.createQuery("SELECT baseDate,imsi FROM BaseData where BaseDate >= :startDate and BaseDate <= :endDate")
    	.setParameter("startDate", calStart, TemporalType.DATE)
        .setParameter("endDate", calEnd, TemporalType.DATE);
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }

public List<BaseData> userStory8(String tac, String startDate, String endDate){
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	
    	
    	startDate=startDate.concat(" 00:00:00");
    	Calendar calStart=Calendar.getInstance();
    	try {
			calStart.setTime(sdf.parse(startDate));
		} catch (ParseException e) {
			System.out.println("Start date not parsing with mins:"+startDate);
			e.printStackTrace();
		}
    	
    	endDate=endDate.concat(" 00:00:00");
    	System.out.println(endDate);
    	Calendar calEnd=Calendar.getInstance();
    	try {
			calEnd.setTime(sdf.parse(endDate));
		} catch (ParseException e) {
			System.out.println("End date not parsing with mins:"+endDate);
			e.printStackTrace();
		}
   
    	Query q = em.createQuery("select count(*) from BaseData where BaseDate >= :startDate and BaseDate <= :endDate and TAC="+ tac)
    	.setParameter("startDate", calStart, TemporalType.DATE)
        .setParameter("endDate", calEnd, TemporalType.DATE);
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }
    
 public List<BaseData> userStory9(String startDate, String endDate){
 	
 	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 	
 	
 	startDate=startDate.concat(" 00:00:00");
 	Calendar calStart=Calendar.getInstance();
 	try {
			calStart.setTime(sdf.parse(startDate));
		} catch (ParseException e) {
			System.out.println("Start date not parsing with mins:"+startDate);
			e.printStackTrace();
		}
 	
 	endDate=endDate.concat(" 00:00:00");
 	System.out.println(endDate);
 	Calendar calEnd=Calendar.getInstance();
 	try {
			calEnd.setTime(sdf.parse(endDate));
		} catch (ParseException e) {
			System.out.println("End date not parsing with mins:"+endDate);
			e.printStackTrace();
		}

 	Query q = em.createQuery("select imsi, userequipment.tac, mccmnc.country.mcc, mccmnc.mnc, sum(duration), COUNT(*) from BaseData where BaseDate >= :startDate and BaseDate <= :endDate group by imsi")
 	.setParameter("startDate", calStart, TemporalType.DATE)
     .setParameter("endDate", calEnd, TemporalType.DATE);
 	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
 }

public List<BaseData> userStory10(String TAC){
		
		//TRYING SOMETHING HERE
		/*String quer = "Select eventcause.eventID as 'Event ID', eventcause.causeCode as 'Cause Code', "
				+"eventcause.causeDescription as Description, reducedTable.count as '#Occurences' "
				+ "from eventcause, (Select eventCauseID, count(*) as count from BaseData "
				+ "where TAC = '" + TAC + "' Group by eventCauseID Order by count DESC)"
				+ "as reducedTable where eventcause.eventcauseCode = reducedTable.eventCauseID;";*/
		String quer = "Select baseDate, imsi from BaseData";
		Query q = em.createQuery("Select baseDate, imsi from BaseData;");
		List<BaseData> listOfBaseData = q.getResultList();
		
		//ArrayList<BaseData> listOfBaseData = new ArrayList<BaseData>();
		return listOfBaseData;
	}

public List<BaseData> userStory11(String startDate, String endDate){
	       
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
       
        startDate=startDate.concat(" 00:00:00");
        Calendar calStart=Calendar.getInstance();
        try {
            calStart.setTime(sdf.parse(startDate));
        } catch (ParseException e) {
            System.out.println("Start date not parsing with mins:"+startDate);
            e.printStackTrace();
        }
       
        endDate=endDate.concat(" 00:00:00");
        System.out.println(endDate);
        Calendar calEnd=Calendar.getInstance();
        try {
            calEnd.setTime(sdf.parse(endDate));
        } catch (ParseException e) {
            System.out.println("End date not parsing with mins:"+endDate);
            e.printStackTrace();
        }
  
        Query q = em.createQuery("select count(*) from BaseData where BaseDate >= :startDate and BaseDate <= :endDate")
        .setParameter("startDate", calStart, TemporalType.DATE)
        .setParameter("endDate", calEnd, TemporalType.DATE);
        List<BaseData> listOfBaseData = q.getResultList();
        return listOfBaseData;
    }
    
    public List<BaseData> userStory14(String failureClassID){
    	Query q = em.createQuery("SELECT baseDate, imsi, eventcause.eventID, eventcause.causeDescription from BaseData where failureClassID =" + Integer.parseInt(failureClassID) + " order by imsi,baseDate");
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }
    
    public List<BaseData> failureClasses(){
    	Query q = em.createQuery("SELECT failureClassID from BaseData group by failureClassID");
    	List<BaseData> listOfBaseData = q.getResultList();
		return listOfBaseData;
    }
    
   public List<Failure> getFailures(String notneeded){
    	Query q = em.createQuery("SELECT o from Failure o");
    	List<Failure> listOfFailures = q.getResultList();
		return listOfFailures;
    }

    
    
}

