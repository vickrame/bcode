/**
 * 
 */
package com.bcode.fwk.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author vickrame
 *
 */
// @Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CATEGORIE", updatable = false)
	private int idCategorie;

	@Column(name = "CODE_CATEGORIE", updatable = false)
	private String codeCategorie;

	private String libelle;

	/**
	 * @return the idCategorie
	 */
	public int getIdCategorie() {
		return idCategorie;
	}

	/**
	 * @param idCategorie
	 *            the idCategorie to set
	 */
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * @return the codeCategorie
	 */
	public String getCodeCategorie() {
		return codeCategorie;
	}

	/**
	 * @param codeCategorie
	 *            the codeCategorie to set
	 */
	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
