/**
 * 
 */
package com.mycompany.mockito.reference.documentation.tutorial.bdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author colin
 *
 */
public class Shop {

	private Seller seller;
	
	private List<Good> goods;
	
	/**
	 * Constructor
	 * 
	 * @param seller
	 */
	public Shop(Seller seller){
		this.seller = seller;
		goods = new ArrayList<Good>();
	}
	
	public List<Good> buyBread(){
		return null;
	}
}
