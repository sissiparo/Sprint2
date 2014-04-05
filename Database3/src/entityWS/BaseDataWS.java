package entityWS;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.BaseData;
import entities.CellTable;
import entities.Failure;
import entityDAO.BaseDataDAO;

@Path("/basedata")
@Stateless
@LocalBean
public class BaseDataWS {

    @EJB
    private BaseDataDAO baseDataDao;
    
     @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/{baseDataID}")
    @Produces("application/json")
    public BaseData getBaseData(@PathParam("baseDataID") int baseDataID) {
        return baseDataDao.getBaseData(baseDataID);
    }
    
    @GET
    @Path("/userStory4/{imsi}")
    @Produces("application/json")
    public List<BaseData> userStory4(@PathParam("imsi") String imsi) {
        return baseDataDao.userStory4(imsi);
    }
//<<<<<<< HEAD
    
//=======
     
//>>>>>>> 580bfc243d6b93925144a8d88b507a3d927ba200
      @GET
    @Path("/userStory5/{imsi}/{startDate}/{endDate}")
    @Produces("application/json")
    public List<BaseData> userStory5(@PathParam("imsi") String imsi, 
    		@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return baseDataDao.userStory5(imsi, startDate, endDate);
    }
    
    @GET
    @Path("/userStory6/{imsi}")
    @Produces("application/json")
    public List<BaseData> userStory6(@PathParam("imsi") String imsi) {
        return baseDataDao.userStory6(imsi);
    }
    

    @GET
    @Path("/userStory7/{startDate}/{endDate}")
    @Produces("application/json")
///<<<<<<< HEAD
    //public List<BaseData> userStory7( 
    //		@PathParam("startDate") Date startDate, @PathParam("endDate") Date endDate) {
//=======
   public List<BaseData> userStory7(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {

        return baseDataDao.userStory7(startDate, endDate);
    }

    @GET
    @Path("/userStory8/{tac}/{startDate}/{endDate}")
    @Produces("application/json")
    public List<BaseData> userStory8(@PathParam("tac") String tac, 
    		@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return baseDataDao.userStory8(tac, startDate, endDate);
    }
    
    @GET
    @Path("/userStory9/{startDate}/{endDate}")
    @Produces("application/json")
    public List<BaseData> userStory9(@PathParam("startDate") String startDate, @PathParam("endDate") String endDate) {
        return baseDataDao.userStory9(startDate, endDate);
    }

//<<<<<<< HEAD

//=======
 @GET
    @Path("/userStory10/{tac}")
    @Produces("application/json")
    public List<BaseData> userStory10(@PathParam("tac") String TAC) {
    	//Query q = em.createQuery("Select baseDate, imsi from BaseData limit 10");
		//List<BaseData> listOfBaseData = q.getResultList();
		//return listOfBaseData;
        return baseDataDao.userStory10(TAC);
    }
    
    @GET
    @Path("/userStory11/{startDate}/{endDate}")
    @Produces("application/json")
    public List<BaseData> userStory11(@PathParam("startDate") String startDate,
    		@PathParam("endDate") String endDate) {
        return baseDataDao.userStory11(startDate, endDate);
    }


 @GET
    @Path("/userStory12/{startDate}/{endDate}")
    @Produces("application/json")
    public List<BaseData> userStory12(@PathParam("startDate") String startDate,
    		@PathParam("endDate") String endDate) {
        return baseDataDao.userStory12(startDate, endDate);
    }



@GET
    @Path("/userStory14/{failureClassID}")
    @Produces("application/json")
    public List<BaseData> userStory14(@PathParam("failureClassID") String failureClassID ) {
        return baseDataDao.userStory14(failureClassID);
    }
    
//>>>>>>> 580bfc243d6b93925144a8d88b507a3d927ba200
    @GET
    @Path("/all")
    @Produces("application/json")
    public List<BaseData> getAllBaseData() {
        return baseDataDao.getAllBaseData();
    }
    
    @GET
    @Path("/imsi/all")
    @Produces("application/json")
    public List<BaseData> getImsiBaseData() {
        return baseDataDao.getImsiBaseData();
    }
    
    
    //failureClasses()
    @GET
    @Path("/failureclasses")
    @Produces("application/json")
    public List<BaseData> failureClasses() {
        return baseDataDao.failureClasses();
    }
    //rest/basedata/getFailures/
    @GET
    @Path("/getFailures/{unneededString}")
    @Produces("application/json")
    public List<Failure> getFailures(@PathParam("unneededString") String unneededString ) {
        return baseDataDao.getFailures(unneededString);
    }
    
    @POST
    public void addBaseDatas(List<BaseData> baseDatas) {
        baseDataDao.addBaseDatas(baseDatas);
    }

}
