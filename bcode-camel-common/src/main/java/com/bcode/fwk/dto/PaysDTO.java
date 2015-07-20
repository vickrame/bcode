package com.bcode.fwk.dto;

import java.io.Serializable;

/**
 * 
 * @author vickrame
 *
 */
public class PaysDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idPays;

	private String codePays;

	private String libelle;

	public PaysDTO() {
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

	/**
	 * @return the idPays
	 */
	public int getIdPays() {
		return idPays;
	}

	/**
	 * @param idPays
	 *            the idPays to set
	 */
	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

}