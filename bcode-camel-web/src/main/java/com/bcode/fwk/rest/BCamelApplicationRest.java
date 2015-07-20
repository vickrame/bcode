/**
 * 
 */
package com.bcode.fwk.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author vickrame
 * 
 *         Workaround from the context CDI and REST when i used a serveur WAS.
 *
 */
@ApplicationPath("/")
public class BCamelApplicationRest extends Application {

	// private Set<Object> singletons = new HashSet<Object>();
	// private Set<Class<?>> empty = new HashSet<Class<?>>();
	//
	// public BCamelApplicationRest() {
	// // below line caused @Inject not to work. commented out
	// // singletons.add(new PersonneAPI());
	// empty.add(PersonneAPI.class);
	// }
	//
	// @Override
	// public Set<Class<?>> getClasses() {
	// return empty;
	// }
	//
	// @Override
	// public Set<Object> getSingletons() {
	// singletons.add(new PersonneAPI());
	// return singletons;
	// }
}
