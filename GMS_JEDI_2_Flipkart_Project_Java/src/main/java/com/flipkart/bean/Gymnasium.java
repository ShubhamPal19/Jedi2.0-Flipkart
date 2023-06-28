/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class Gymnasium {
	private String gymId; // ID of the gymnasium.
	private String ownerId; // ID of the gym owner.
	
	private String name; // Name of the gymnasium.
	private String address; // Address of the gymnasium.
	private double totalArea; // Total area of the gymnasium.
	private int numItem; // Number of items in the gymnasium.
	
	private boolean approved; // Approval status of the gymnasium.
	
	/**
	 * Default constructor for the Gymnasium class.
	 */
	public Gymnasium() {
		
	}
	
	/**
	 * Returns the ID of the gymnasium.
	 *
	 * @return the gymnasium ID
	 */
	public String getGymId() {
		return gymId;
	}
	
	/**
	 * Sets the ID for the gymnasium.
	 *
	 * @param gymId the gymnasium ID to set
	 */
	public void setGymId(String gymId) {
		this.gymId = gymId;
	}
	
	/**
	 * Returns the name of the gymnasium.
	 *
	 * @return the name of the gymnasium
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name of the gymnasium.
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the address of the gymnasium.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	
	/**
	 * Sets the address for the gymnasium.
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	/**
	 * Returns the total area of the gymnasium.
	 *
	 * @return the total area
	 */
	public double getTotalArea() {
		return totalArea;
	}
	
	/**
	 * Sets the total area for the gymnasium.
	 *
	 * @param totalArea the total area to set
	 */
	public void setTotalArea(double totalArea) {
		this.totalArea = totalArea;
	}
	
	/**
	 * Returns the number of items in the gymnasium.
	 *
	 * @return the number of items
	 */
	public int getNumItem() {
		return numItem;
	}
	
	/**
	 * Sets the number of items for the gymnasium.
	 *
	 * @param numItem the number of items to set
	 */
	public void setNumItem(int numItem) {
		this.numItem = numItem;
	}
	
	/**
	 * Returns the ID of the gym owner.
	 *
	 * @return the owner ID
	 */
	public String getOwnerId() {
		return ownerId;
	}

	/**
	 * Sets the ID for the gym owner.
	 *
	 * @param ownerId the owner ID to set
	 */
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	
	/**
	 * Checks if the gymnasium is approved.
	 *
	 * @return true if approved, false otherwise
	 */
	public boolean isApproved() {
		return approved;
	}

	/**
	 * Sets the approval status for the gymnasium.
	 *
	 * @param approved the approval status to set
	 */
	public void setApproved(boolean approved) {
		this.approved = approved;
	}
}