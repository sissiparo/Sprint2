package rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Stateless
@Path("/rest")
public class RestApplication {

	@GET
	//@Path("{name}")
	@Produces({"application/xml","application/json", "text/plain"})
	//public String sayHello(@PathParam("name") String name){
	// return "hello "+ name;
	public String sayHello(){
		return "hello";
	}
}
