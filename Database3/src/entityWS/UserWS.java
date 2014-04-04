package entityWS;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import entities.User;
import entityDAO.UserDAO;

@Path("/user")
@Stateless
@LocalBean
public class UserWS {

	@EJB
	private UserDAO userDao;


	@GET
	@Path("/all")
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
	
	@GET
	@Path("/{userName}")
	@Produces("application/json")
	public User getUserNamePassword(@PathParam("userName") String userName) {
		return userDao.getUserName(userName);
	}

	@GET
	@Path("/{userName}/{password}")
	@Produces("application/json")
	public User getUserNamePassword(@PathParam("userName") String userName,
			@PathParam("password") String password) {
		return userDao.getUserNamePassword(userName, password);
	}

	@POST
	@Path("/{userName}/{password}/{employeeNumber}/{firstName}/{lastName}/{userType}")
	public void addUsers(@PathParam("userName") String userName,
			@PathParam("password") String password,
			@PathParam("employeeNumber") String employeeNumber,
			@PathParam("firstName") String firstName,
			@PathParam("lastName") String lastName,
			@PathParam("userType") String userType) {
		User user = new User(userName, password, employeeNumber, firstName,
				lastName, userType.replaceAll("_", " "));
		userDao.addUser(user);
	}

}
