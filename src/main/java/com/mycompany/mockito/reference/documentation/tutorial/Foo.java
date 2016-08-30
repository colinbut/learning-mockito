/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial;

/**
 * @author colin
 *
 */
public class Foo {

	private String name = "Foo";
	
	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public Foo(String name){
		this.name = name;
	}
	
	public String getModifiedName(String extension){
		return name + extension;
	}
}
