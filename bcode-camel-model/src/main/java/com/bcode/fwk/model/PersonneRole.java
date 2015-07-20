package com.bcode.fwk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


/**
 * 
 * @author vickrame
 *
 */
@Entity
@NamedQuery(name="PersonneRole.findAll", query="SELECT p FROM PersonneRole p")
public class PersonneRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERSONNE_ROLE")
	private int idPersonneRole;


	@ManyToOne
	@JoinColumn(name="ID_PERSONNE")
	private Personne personne;

	@OneToOne
	@JoinColumn(name="ID_ROLE")
	private RoleRef roleRef;

	public PersonneRole() {
	}

	public int getIdPersonneRole() {
		return this.idPersonneRole;
	}

	public void setIdPersonneRole(int idPersonneRole) {
		this.idPersonneRole = idPersonneRole;
	}


	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public RoleRef getRoleRef() {
		return this.roleRef;
	}

	public void setRoleref(RoleRef roleRef) {
		this.roleRef = roleRef;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonneRole [idPersonneRole=").append(idPersonneRole).append("]");
		return builder.toString();
	}

}