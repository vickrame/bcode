package com.bcode.fwk.dto;

import java.io.Serializable;

/**
 * 
 * @author vickrame
 *
 */

public class CommentaireDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCommentaire;

	private String description;

	// celle qui fait le commentaire
	private PersonneDTO personne;

	// sur lequel porte le commentaire
	private RecetteDTO recette;

	public CommentaireDTO() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PersonneDTO getPersonne() {
		return this.personne;
	}

	public void setPersonne(PersonneDTO personne) {
		this.personne = personne;
	}

	public RecetteDTO getRecette() {
		return this.recette;
	}

	public void setRecette(RecetteDTO recette) {
		this.recette = recette;
	}

	/**
	 * @return the idCommentaire
	 */
	public int getIdCommentaire() {
		return idCommentaire;
	}

	/**
	 * @param idCommentaire
	 *            the idCommentaire to set
	 */
	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

}