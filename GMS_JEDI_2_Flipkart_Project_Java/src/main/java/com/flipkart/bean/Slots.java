/**
 * 
 */
package com.flipkart.bean;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * 
 */
public class Slots {
	private String slotId; // ID of the slot.
	private String gymId; // ID of the gymnasium.

	private int capacity; // Capacity of the slot.
	private LocalTime time; // Time of the slot.
	
	/**
	 * Default constructor for the Slots class.
	 */
	public Slots() {
		
	}
	
	/**
	 * Returns the ID of the slot.
	 *
	 * @return the slot ID
	 */
	public String getSlotId() {
		return slotId;
	}
	
	/**
	 * Sets the ID for the slot.
	 *
	 * @param slotId the slot ID to set
	 */
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	
	/**
	 * Returns the capacity of the slot.
	 *
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}
	
	/**
	 * Sets the capacity for the slot.
	 *
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
	 * Returns the time of the slot.
	 *
	 * @return the time
	 */
	public LocalTime getTime() {
		return time;
	}
	
	/**
	 * Sets the time for the slot.
	 *
	 * @param time the time to set
	 */
	public void setTime(LocalTime time) {
		this.time = time;
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
}