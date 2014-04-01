package entityDAO;

import java.util.Collection;

import entities.AccessCapability;

public interface IAccessCapabilityDAO {

	void addAccessCapability(AccessCapability accessCapability);
	AccessCapability getAccessCapabilityByName(String name);
	Collection<AccessCapability> getAllAccessCapabilities();
}
