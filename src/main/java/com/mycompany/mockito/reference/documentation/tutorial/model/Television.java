/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial.model;

import java.awt.Color;

/**
 * @author colin
 *
 */
public class Television {

	public enum TelevisionType {
		
		LCD,
		
		PLASMA,
		
		TRADITIONAL,
		
	}
	
	private TelevisionType tvType;
	private int inch;
	private Color color;
	private Remote remoteControl;
	
	
	/**
	 * @return the tvType
	 */
	public TelevisionType getTvType() {
		return tvType;
	}

	/**
	 * @param tvType the tvType to set
	 */
	public void setTvType(TelevisionType tvType) {
		this.tvType = tvType;
	}

	/**
	 * @return the inch
	 */
	public int getInch() {
		return inch;
	}

	/**
	 * @param inch the inch to set
	 */
	public void setInch(int inch) {
		this.inch = inch;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * @return the remoteControl
	 */
	public Remote getRemoteControl() {
		return remoteControl;
	}

	/**
	 * @param remoteControl the remoteControl to set
	 */
	public void setRemoteControl(Remote remoteControl) {
		this.remoteControl = remoteControl;
	}

	public TVState switchOn(){
		return remoteControl.switchOn();
	}
	
	public TVState switchOff(){
		return remoteControl.switchOff();
	}
	
	public int turnUpVolume(){
		return remoteControl.volumeUp();
	}
	
	public int turnDownVolume(){
		return remoteControl.volumeDown();
	}
	
	public int mute(){
		return remoteControl.mute();
	}
	
	public void watchTV(){
		// watching TV
	}
	
	
	
	
	
}
