package com.bcode.fwk.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 
 * @author vickrame
 *
 */
@XmlRootElement
public class RoleRefDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idRole;

	private String codeRole;

	private String libelle;


	public RoleRefDTO() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getCodeRole() {
		return this.codeRole;
	}

	public void setCodeRole(String codeRole) {
		this.codeRole = codeRole;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


}