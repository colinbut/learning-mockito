/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial.model;

/**
 * @author colin
 *
 */
public interface Remote {

	TVState switchOn();
	
	TVState switchOff();
	
	TVState putToStandby();
	
	int volumeUp();
	
	int volumeDown();
	
	int mute();
	
	Channel changeChannel();
}
