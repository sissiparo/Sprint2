package entityWS;

import java.util.Collection;

import javax.ejb.Remote;
import javax.jws.WebService;

import entities.AccessCapability;

@WebService
@Remote
public interface IAccessCapabilityService {
	public Collection<AccessCapability> getCatalog();
	public void addToCatalog(AccessCapability accessCapability);
	
}
