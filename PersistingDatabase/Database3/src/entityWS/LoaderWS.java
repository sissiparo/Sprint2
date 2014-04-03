package entityWS;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import entityDAO.CountryDAO;
import loader.CountryConfig;
import loader.AccessCapabilityConfig;
import loader.FailureConfig;
import loader.MCCMNCConfig;
//import loader.UserConfig;
import loader.EventCauseConfig;
import loader.ManufacturerConfig;
import loader.UEModelConfig;
import loader.CellTableConfig;
import loader.CountryConfig;
import loader.EventCauseConfig;
import loader.FailureConfig;
import loader.MCCMNCConfig;
import loader.AccessCapabilityConfig;
import loader.BaseDataAndCellTableConfig;
import loader.ManufacturerConfig;
import loader.UE_AccessCapabilityConfig;
import loader.UEModelConfig;
import loader.UserConfig;
import loader.UserEquipmentConfig;



@Path("/load")
@Stateless
@LocalBean
public class LoaderWS {
	
	@EJB
    private CountryDAO countriesDao;
    
    @EJB
    private CountryConfig config;

    @EJB
    private MCCMNCConfig mccmncConfig;

    @EJB
    private EventCauseConfig eventCauseConfig;
    
    @EJB
    private FailureConfig failureConfig;
    
    @EJB
    private AccessCapabilityConfig accConfig;
    
    @EJB
    private ManufacturerConfig manufacturerConfig;
    
    @EJB
    private UE_AccessCapabilityConfig ueacConfig;
    
    @EJB
    private UEModelConfig ueModelConfig;
    
    @EJB
    private UserEquipmentConfig userEquipConfig;
    
    @EJB
    private BaseDataAndCellTableConfig bdactConfig;
    
    @EJB
    private CellTableConfig ctConfig;
    
    @EJB
    private UserConfig userConfig;
    
    @POST
    @Path("/add")
    public void addAll() {
    	long startTime = System.nanoTime();

      config.addCountries();
      mccmncConfig.addMCCMNC();
      eventCauseConfig.addEventCause();
      failureConfig.addFailures();
      accConfig.addAccessCapability();
      manufacturerConfig.addManufacturer();
      ueacConfig.addUeAccessCapability();
      ueModelConfig.addUEModel();
      userEquipConfig.addUserEquipment();
      ctConfig.addBaseDataAndCellTableConfig();
      userConfig.addUsers();
      bdactConfig.addBaseDataAndCellTableConfig();
    	
        long endTime = System.nanoTime();
		
		System.out.println("Upload took " + (endTime-startTime)/1000000000 + " seconds");
    }

}
