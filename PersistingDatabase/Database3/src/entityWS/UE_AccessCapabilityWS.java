package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

//import entities.UE_AccessCapability;
import entities.UeAccessCapability;
import entityDAO.UE_AccessCapabilityDAO;

@Path("/ue_accesscapability")
@Stateless
@LocalBean
public class UE_AccessCapabilityWS {

    @EJB
    private UE_AccessCapabilityDAO ue_accessCapabilitysDao;

    @GET
    @Path("/{userEquipID}")
    public UeAccessCapability getUE_AccessCapability(@PathParam("userEquipID") String userEquipID) {
        return ue_accessCapabilitysDao.getUE_AccessCapability(userEquipID);
    }
    
    @GET
    @Path("/all")
    public List<UeAccessCapability> getAllUE_AccessCapability() {
        return ue_accessCapabilitysDao.getAllUE_AccessCapability();
    }
    
    @POST
    public void addUE_AccessCapabilitys(List<UeAccessCapability> ue_accessCapabilities) {
        ue_accessCapabilitysDao.addUE_AccessCapabilitys(ue_accessCapabilities);
    }
    
}