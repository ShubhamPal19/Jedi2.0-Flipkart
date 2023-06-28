/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.*;
import java.util.*;
import com.flipkart.dao.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.ResultSet;

/**
 * 
 */

@Path("admin")
public class AdminGMSService implements AdminGMSInterface{
	
	AdminGMSDao adminDBService = new AdminGMSDao();
	
	public AdminGMSService() {
//		seeAllGyms();
	}
	
	/**
	 * Displays all gym owners.
	 */

	@Path("view/owner/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GymOwner> seeAllGymOwner() {

		System.out.println("in see gymowner ");
		return adminDBService.fetchGymOwnerDetails();

	}
	
	/**
	 * Displays all gyms.
	 */


	@Path("view/gym/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gymnasium> seeAllGyms() {
		return adminDBService.fetchGymnasiumDetails();
	}
	
	/**
	 * Checks if there are pending gym owner requests.
	 *
	 * @return true if there are pending gym owner requests, false otherwise
	 */

	@Path("req/pending/owner")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<GymOwner> seePendingGymOwnerRequest() {
		return adminDBService.fetchPedningGymOwnerRequests();
		
	}
	
	/**
	 * Checks if there are pending gym requests.
	 *
	 * @return true if there are pending gym requests, false otherwise
	 */

	@Path("req/pending/gym")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gymnasium> seePendingGymRequest() {
		return adminDBService.fetchPendingGymnasiumRequest();
	}
	
	/**
	 * Approves a single gym owner request with the specified request ID.
	 *
	 * @param requestId the ID of the gym owner request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */

	@Path("approve/owner")
	@GET

	public boolean approveSingleOwnerRequest(@QueryParam("id") String requestId) {
		adminDBService.updateSingleGymOwnerRequests(requestId);
		return true;
	}
	
	/**
	 * Approves all pending gym owner requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */

	@Path("approve/owner/all")
	@GET

	public boolean approveAllOwnerRequest() {
		adminDBService.updateAllPendingGymOwnerRequests();
		return true;
	}
	
	/**
	 * Approves a single gym request with the specified gym ID.
	 *
	 * @param gymId the ID of the gym request to approve
	 * @return true if the request is approved successfully, false otherwise
	 */

	@Path("approve/gym")
	@GET
	public boolean approveSingleGymRequest(@QueryParam("id") String gymId) {
		adminDBService.updateSingleGymnasiumRequests(gymId);
		return true;
	}
	
	/**
	 * Approves all pending gym requests.
	 *
	 * @return true if all requests are approved successfully, false otherwise
	 */

	@Path("approve/gym/all")
	@GET
	public boolean approveAllGymRequest() {
		adminDBService.updateAllPendingGymnasiumRequests();
		return true;
	}

	/**
	 * Blocks a gym owner with the specified owner ID.
	 *
//	 * @param gymOwnerId the ID of the gym owner to block
	 */
	@Path("block/owner")
	@GET
	public void blockGymOwner(@QueryParam("id") String gynOwnerId) {
		adminDBService.unApproveGymOwner(gynOwnerId);
	}
}