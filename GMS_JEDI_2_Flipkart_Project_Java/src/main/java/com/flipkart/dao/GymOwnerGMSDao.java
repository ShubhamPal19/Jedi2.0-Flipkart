/**
 * DAO class for Gym Owner management system.
 */
package com.flipkart.dao;
import java.sql.Connection;
import com.flipkart.bean.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DBUtils;

/**
 * DAO class that provides database operations for Gym Owner management system.
 */
public class GymOwnerGMSDao {
	
	
	/**
	 * Registers a new gym owner in the database.
	 *
	 * @param user  The user information.
	 * @param owner The gym owner information.
	 */
	public void registerGymOwner(User user, GymOwner owner) {
		
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// Getting owner Id
			conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYMOWNER_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
//		    user.setUserName(Integer.toString(count));
		    
		    
		    
		    // Registering in Owner schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, owner.getName());
		    stmt.setString(3, owner.getMobile());
		    stmt.setString(4, owner.getEmail());
		    stmt.setString(5, owner.getAddress());
		    stmt.setString(6, owner.getAadhaarNumber());
		    stmt.setString(7, owner.getPanNumber());
		    stmt.setString(8, owner.getGstNumber());
		    
		    stmt.executeUpdate();
		    
		    
		    // Getting RegId
		    conn = DBUtils.getConnection();
			stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYMOWNER_REG_QUERY);
		    output = stmt.executeQuery();
		    output.next();
		    count = output.getInt(1);
		    count++;
		    
		    String regId = new String();
		    regId = (Integer.toString(count));
		    
		    
		    // Registering in CustomerRegistration Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_REG_QUERY);
		    stmt.setString(1, regId);
		    stmt.setString(2, user.getUserName());
		    stmt.executeUpdate();
		    
		    
		    // Registering in User Schema
		    stmt = conn.prepareStatement(SQLConstants.SQL_REGISTER_GYMOWNER_USER_QUERY);
		    stmt.setString(1, user.getUserName());
		    stmt.setString(2, user.getPassword());
		    stmt.setInt(3, 2);
		    
		    stmt.executeUpdate();
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	
	/**
	 * Fetches the details of a gym owner from the database.
	 *
	 * @param userName The username of the gym owner.
	 */
	public void fetchOwnerDetails(String userName) {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_SING_OWNER_DET_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    System.out.println("\tID\tGymOwner Name");
		    if(output.next()) {
		    	System.out.println("\t"+output.getString(1) + "\t " + output.getString(2));
		    }
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	/**
	 * Fetches the list of gyms owned by a gym owner from the database.
	 *
	 * @param userName The username of the gym owner.
	 */
	public void fetchMyGyms(String userName) {
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_OWNER_GYM_DET_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    System.out.println("\tID\tGymnasium Name");
		    while(output.next()) {
		    	System.out.println("\t"+output.getString(1) + "\t " + output.getString(2));
		    }
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	}
	
	/**
	 * Checks if a gym owner is approved based on their username.
	 *
	 * @param userName The username of the gym owner.
	 * @return true if the gym owner is approved, false otherwise.
	 */
	public boolean isOwnerApproved(String userName) {
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_FETCH_OWNER_APPROVAL_QUERY);
		    stmt.setString(1, userName); 
	
		    ResultSet output = stmt.executeQuery();
		    if(output.next()) return output.getBoolean(1);
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    return false;
	}
	
	/**
	 * Adds gym details to the database.
	 *
	 * @param gym             The gymnasium information.
	 * @param slotAvailable   The list of available slots.
	 * @param capacity        The capacity of the gym.
	 */
	public void addGymDetails(Gymnasium gym, ArrayList<Integer> slotAvailable, int capacity) {
		   
		Connection conn = null;
		PreparedStatement stmt = null;
		   
	    try {
	    	conn = DBUtils.getConnection();
		   
		    stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_GYM_QUERY);
		    ResultSet output = stmt.executeQuery();
		    output.next();
		    int count = output.getInt(1);
		    count++;
		    
		    gym.setGymId(Integer.toString(count));
		    
		    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_GYM_QUERY);
		    stmt.setString(1, gym.getGymId());
		    stmt.setString(2, gym.getName());
		    stmt.setString(3, gym.getAddress());
		    stmt.setDouble(4, gym.getTotalArea());
		    stmt.setInt(5, gym.getNumItem());
		    stmt.setInt(6, 0);
		    stmt.setString(7, gym.getOwnerId());
		    
		    stmt.executeUpdate();
		    
	    } catch(SQLException sqlExcep) {
//		       System.out.println(sqlExcep);
	    } catch(Exception excep) {
	           excep.printStackTrace();
	    }
	    
	    List<String> days=new ArrayList<String>();
	    days.add("Monday");days.add("Tuesday");days.add("Wednesday");days.add("Thursday");
	    days.add("Friday");days.add("Saturday");days.add("Sunday");
	    
	    
	    for (String i : days) {
	    	for (Integer j : slotAvailable) {
	    		try {
	    			conn = DBUtils.getConnection();
					   
				    stmt = conn.prepareStatement(SQLConstants.SQL_SIZE_SLOTS_QUERY);
				    ResultSet output = stmt.executeQuery();
				    output.next();
				    int count = output.getInt(1);
				    count++;
				    
				    String slotId = Integer.toString(count);
				    
				    stmt = conn.prepareStatement(SQLConstants.SQL_INSERT_SLOTS_QUERY);
				    stmt.setString(1, slotId);
				    stmt.setString(2, gym.getGymId());
				    stmt.setInt(3, capacity);
				    stmt.setString(4, i);
				    stmt.setInt(5, j);
				    
				    stmt.executeUpdate();
				    
				    
				    
	    		}catch(SQLException sqlExcep) {
//				       System.out.println(sqlExcep);
			    } catch(Exception excep) {
			           excep.printStackTrace();
			    }
	        }
        }
	    
	    
	    return;
	}
	
}
