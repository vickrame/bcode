/**
 * 
 */
package com.bcode.fwk.core;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author vickrame
 *
 */

public class LoggerFactory {

	

        @Produces 
        private Logger getLogger(InjectionPoint caller){
            return LogManager.getLogger(caller.getMember().getDeclaringClass().getName());
        }
}
