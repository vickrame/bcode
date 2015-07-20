/**
 * 
 */
package com.bcode.fwk.services;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * @author vickrame
 *
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TestService {

	public TestService() {

	}
}
