/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial.model;

/**
 * @author colin
 *
 */
public class Car {

	private int numberOfDoors = 5;
	private boolean manual = true; // otherwise automatic
	private int gears;
	private int gear; // current gear
	
	public Car(){
		gears = 5;
	}
	
	/**
	 * @return the numberOfDoors
	 */
	public int getNumberOfDoors() {
		return numberOfDoors;
	}

	/**
	 * @param numberOfDoors the numberOfDoors to set
	 */
	public void setNumberOfDoors(int numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	/**
	 * @return the manual
	 */
	public boolean isManual() {
		return manual;
	}

	/**
	 * @param manual the manual to set
	 */
	public void setManual(boolean manual) {
		this.manual = manual;
	}

	/**
	 * @return the gears
	 */
	public int getGears() {
		return gears;
	}

	/**
	 * @param gears the gears to set
	 */
	public void setGears(int gears) {
		this.gears = gears;
	}

	/**
	 * @return the gear
	 */
	public int getGear() {
		return gear;
	}

	/**
	 * @param gear the gear to set
	 */
	public void setGear(int gear) {
		this.gear = gear;
	}

	public void drive(){
		moveGearUp(2);
		// drive the car
	}
	
	private boolean moveGearUp(int moveUps){
		
		boolean success = false;
		
		if( success = (gear + moveUps <= gears)) {
			gear+= moveUps;
		}
		
		return success;
	}
	
	public boolean openDoor(){
		// opens the door
		return false;
	}
}
