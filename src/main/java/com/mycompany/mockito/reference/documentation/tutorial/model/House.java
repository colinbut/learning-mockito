/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial.model;

/**
 * @author colin
 *
 */
public abstract class House implements Property {

	private int houseNumber;
	private String houseName;
	private int noOfBedrooms;
	private String address;
	
	/**
	 * 
	 * @return the houseNumber
	 */
	public int getHouseNumber() {
		return houseNumber;
	}
	/**
	 * @param houseNumber the houseNumber to set
	 */
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	/**
	 * @return the houseName
	 */
	public String getHouseName() {
		return houseName;
	}
	/**
	 * @param houseName the houseName to set
	 */
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	/**
	 * @return the noOfBedrooms
	 */
	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}
	/**
	 * @param noOfBedrooms the noOfBedrooms to set
	 */
	public void setNoOfBedrooms(int noOfBedrooms) {
		this.noOfBedrooms = noOfBedrooms;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
}
