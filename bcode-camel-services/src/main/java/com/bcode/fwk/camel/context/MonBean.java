/**
 * 
 */
package com.bcode.fwk.camel.context;

import java.io.Serializable;

import javax.inject.Named;

/**
 * @author vickrame
 *
 */
@Named
public class MonBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8355513918220976687L;
	
	private String attribut1;

	public MonBean() {

	}

	public void getNom() {
		System.out.println("Allo ");
	}

	/**
	 * @return the attribut1
	 */
	public String getAttribut1() {
		return attribut1;
	}

	/**
	 * @param attribut1 the attribut1 to set
	 */
	public void setAttribut1(String attribut1) {
		this.attribut1 = attribut1;
	}
}
