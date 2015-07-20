package com.bcode.fwk.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author vickrame
 *
 */
@XmlRootElement
public class PersonneRoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private RoleRefDTO roleRef;

	public PersonneRoleDTO() {
	}

	public RoleRefDTO getRoleRef() {
		return this.roleRef;
	}

	public void setRoleref(RoleRefDTO roleRef) {
		this.roleRef = roleRef;
	}

}