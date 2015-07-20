/**
 * 
 */
package com.bcode.fwk.camel.context.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * @author vickrame
 *
 */
public class MonProcessor implements Processor {

	/* (non-Javadoc)
	 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
	 */
	@Override
	public void process(Exchange arg0) throws Exception {
		System.out.println(arg0.getIn().getBody());

	}

}
