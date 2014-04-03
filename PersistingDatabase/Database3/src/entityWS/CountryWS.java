package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
import loader.UserEquipmentConfig;
import entities.Country;
import entityDAO.CountryDAO;

@Path("/country")
@Stateless
@LocalBean
public class CountryWS {

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
    
    @GET
    @Path("/{mcc}")
    public Country getCountry(@PathParam("mcc") int mcc) {
        return countriesDao.getCountry(mcc);
    }
    
    @GET
    @Path("/all")
    public List<Country> getAllCountry() {
        return countriesDao.getAllCountry();
    }
    
//    @POST
//    public void addCountry(Country country) {
//        countriesDao.addCountry(country);
//    }
    
    @GET
    @Path("/add/countries")
    public void addCountries() {
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
        bdactConfig.addBaseDataAndCellTableConfig();
        
    }
    
}