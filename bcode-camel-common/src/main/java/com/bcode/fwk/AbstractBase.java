/**
 * 
 */
package com.bcode.fwk;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.logging.log4j.Logger;

/**
 * @author vickrame
 *
 */
public abstract class AbstractBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2201234443468289898L;
	
		
	public AbstractBase(){
	}
	
	@Inject
	protected Logger logger;
	
}
