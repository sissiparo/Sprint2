package entityWS;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import entities.BaseData;
import entities.Country;
import entityDAO.AccessCapabilityDAO;
import entityDAO.BaseDataDAO;
import entityDAO.CellTableDAO;
import entityDAO.CountryDAO;
import entityDAO.EventCauseDAO;

@Path("/loadfile")
@Stateless
@LocalBean
public class LoadDataWS {
	
	
    @EJB
    private BaseDataDAO baseDataDao;
    
    @EJB
    private AccessCapabilityDAO accessCapabilityDao;
    
    @EJB
    private CellTableDAO cellTableDao;
    
    @EJB
    private CountryDAO countryDao;
    
    @EJB
    private EventCauseDAO eventCauseDao;
    
    @GET
    @Path("/country")
    public void addCountries() {
    	System.out.println("test");
    }

}
