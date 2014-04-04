package entityDAO;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entities.BaseData;
import entities.User;
	
	@Stateless
	@LocalBean
	public class UserDAO {

	    @PersistenceContext
	    private EntityManager em;
	    
	    public User getUser(int userId) {
	        return em.find(User.class, userId);
	    }
	    
	    public List<User> getAllUser(){
		    TypedQuery<User> q = em.createQuery("select o from User o", User.class);
		    List<User> listOfUser = q.getResultList();
		    return listOfUser;
	    }
	    
	    public User getUserName(String userName){
		    TypedQuery<User> q = em.createNamedQuery("User.findUserName", User.class);
		    q.setParameter("userName", userName);
		    User user = q.getResultList().get(0);
		    return user;
	    }
	    
	    public User getUserNamePassword(String userName, String password){
		    TypedQuery<User> q = em.createNamedQuery("User.findUserNamePassword", User.class);
		    q.setParameter("userName", userName);
		    q.setParameter("password", password);
		    User user = q.getResultList().get(0);
		    return user;
	    }
	    
	    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	    public void addUsers(List<User> users) {
	        for (User user : users) {
	            em.persist(user);
	        }
	    }
	    
	    @TransactionAttribute(TransactionAttributeType.REQUIRED)
	    public void addUser(User user) {
	            em.persist(user);
	        
	    }

}
