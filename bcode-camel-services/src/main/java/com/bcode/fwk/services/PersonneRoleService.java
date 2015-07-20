/**
 * 
 */
package com.bcode.fwk.services;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.bcode.fwk.GenericService;
import com.bcode.fwk.dto.PersonneRoleDTO;
import com.bcode.fwk.model.PersonneRole;

/**
 * @author vickrame
 *
 */
@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonneRoleService extends
		GenericService<PersonneRole, PersonneRoleDTO> {

	public static final String GET_ALL = "PersonneRole.findAll";

	public PersonneRoleService() {
		super(PersonneRole.class);
	}

	@Override
	protected PersonneRoleDTO transformModelToDTO(PersonneRole entiteList) {

		PersonneRoleDTO dto = new PersonneRoleDTO();
		return dto;
	}

}
