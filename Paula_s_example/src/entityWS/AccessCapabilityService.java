package entityWS;

import java.util.Collection;

import javax.annotation.Resource;
import javax.ejb.Remote;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.jws.WebService;

import entityDAO.IAccessCapabilityDAO;
import entities.AccessCapability;


@Stateless
@WebService(endpointInterface="IAccessCapabilityService")
@Remote(IAccessCapabilityService.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class AccessCapabilityService implements IAccessCapabilityService{

	@Inject
	private IAccessCapabilityDAO accesCapabilityDAO;
	
	@Resource
	private SessionContext context;
	
	public void setDao(IAccessCapabilityDAO accesCapabilityDAO){
		this.accesCapabilityDAO=accesCapabilityDAO;
	}
	
	
	public Collection<AccessCapability> getCatalog() {
	
		return accesCapabilityDAO.getAllAccessCapabilities();
	}

	
	public void addToCatalog(AccessCapability accessCapability) {
		if (!accesCapabilityDAO.getAllAccessCapabilities().contains(accessCapability)){
			accesCapabilityDAO.addAccessCapability(accessCapability);
			
		}
		
	}
	
	

}
