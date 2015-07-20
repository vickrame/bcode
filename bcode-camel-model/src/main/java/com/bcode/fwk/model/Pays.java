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
		@NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"),
		@NamedQuery(name = "Pays.findPaysByCode", query = "SELECT p FROM Pays p where p.codePays = :codePays") })
public class Pays implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PAYS", updatable = false)
	private int idPays;

	@Column(name = "CODE_PAYS", updatable = false)
	private String codePays;

	private String libelle;

	public Pays() {
	}

	public int getIdPays() {
		return this.idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	public String getCodePays() {
		return this.codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
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
		builder.append("Pays [idPays=").append(idPays).append(", codePays=")
				.append(codePays).append(", libelle=").append(libelle)
				.append("]");
		return builder.toString();
	}

}