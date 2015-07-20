/**
 * 
 */
package com.bcode.fwk.camel.context.route;

import javax.inject.Named;

import org.apache.camel.builder.RouteBuilder;

/**
 * @author vickrame
 *
 */
@Named
public class UneRoute extends RouteBuilder {


	private String data;
	public UneRoute(){
		System.out.println("creation de la route");
	}
	
	private String uriEndpoint;
	/* (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 */
	@Override
	public void configure() throws Exception {

        from(uriEndpoint).routeId("123456789")
        // Set Body with text "Bean Injected"
        .setBody().simple("Bean Injected")
        // Lookup for bean injected by CDIcontainer
        .beanRef("monBean", "getNom")
        // Display response received in log when calling HelloWorld
        .log(">> Response : ${body}");
	}
	/**
	 * @return the uriEndpoint
	 */
	public String getUriEndpoint() {
		return uriEndpoint;
	}
	/**
	 * @param uriEndpoint the uriEndpoint to set
	 */
	public void setUriEndpoint(String uriEndpoint) {
		this.uriEndpoint = uriEndpoint;
	}

}
