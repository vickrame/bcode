/**
 * 
 */
package com.bcode.fwk.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author vickrame
 *
 */
public class PersistenceManager {

	@PersistenceContext(unitName = "uniteTest")
	private EntityManager em;
	
	
	@Produces
	public EntityManager provideEM(){
		return em;
	}
}
