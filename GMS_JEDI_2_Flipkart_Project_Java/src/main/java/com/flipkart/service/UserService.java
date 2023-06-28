/**
 * 
 */
package com.flipkart.service;
import com.flipkart.bean.*;
import com.flipkart.dao.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.awt.*;

/**
 * 
 */

@Path("user")
public class UserService implements UserServiceInterface {
	UserGMSDao dbService = new UserGMSDao();
	
	/**
	 * Constructs a new UserService object.
	 */
	public UserService() {
		
	}
	
	/**
	 * Registers a customer with the provided registration data.
	 *
	 * @param customerData the registration data for the customer
	 * @return true if the registration is successful, false otherwise
	 */

	@Path("register/customer")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean registerCustomer(Registration customerData) {
		return true;
	}
	
	/**
	 * Registers a gym owner with the provided registration data.
	 *
	 * @param ownerData the registration data for the gym owner
	 * @return true if the registration is successful, false otherwise
	 */

	@Path("register/gymowner")
	@POST
	public boolean registerGymOwner(Registration ownerData) {
		return true;
	}
	
	/**
	 * Authenticates a user with the provided user data.
	 *
	 * @param userData the user data for authentication
	 * @return the authentication result as an integer code:
	 *         - 0 for successful authentication
	 *         - 1 for invalid username or password
	 *         - 2 for account locked
	 *         - 3 for account expired
	 */

	@Path("login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public int authenticateUser(User userData) {

		String userName = userData.getUserName();
		String password = userData.getPassword();


		return dbService.authenticateUser(userName, password);
	}
	
	/**
	 * Logs out a user with the provided user data.
	 *
	 * @param userData the user data for logout
	 * @return true if the logout is successful, false otherwise
	 */

	@GET
	@Consumes("application/json")
	public boolean logout(User userData) {

		return true;
	}
}