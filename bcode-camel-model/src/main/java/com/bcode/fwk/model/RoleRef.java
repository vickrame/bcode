package com.bcode.fwk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * 
 * @author vickrame
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "RoleRef.findAll", query = "SELECT r FROM RoleRef r"),
		@NamedQuery(name = "RoleRef.findByCode", query = "SELECT r FROM RoleRef r where r.codeRole = :codeRole") })
public class RoleRef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ROLE", updatable = false)
	private int idRole;

	@Column(name = "CODE_ROLE", updatable = false)
	private String codeRole;

	private String libelle;

	public RoleRef() {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RoleRef [idRole=").append(idRole).append(", codeRole=")
				.append(codeRole).append(", libelle=").append(libelle)
				.append("]");
		return builder.toString();
	}

}