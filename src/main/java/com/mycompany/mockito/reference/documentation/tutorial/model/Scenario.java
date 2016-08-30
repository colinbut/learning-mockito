/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial.model;

/**
 * @author colin
 *
 */
public class Scenario {

	public void watchTV(){
		
		Human person = new Person();
		
		((Person) person).takeRemoteControl(new RemoteControl());
		
	}
}
