/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial.model;

/**
 * @author colin
 *
 */
public class Person extends Individual {

	private String name;
	private int age;
	private Sex sex;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public Sex getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public void takeRemoteControl(Remote remote){
		//
	}
	
	
	
}
