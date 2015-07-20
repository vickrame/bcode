package com.bcode.fwk.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author vickrame
 *
 */
@XmlRootElement
public class RecetteDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idRecette;

	private String imageBase64;

	private byte[] ingredientJson;

	private String nomRecette;

	private int nbreCommentaire;

	private List<CommentaireDTO> commentaires;

	private PaysDTO pays;

	private PersonneDTO personne;

	public RecetteDTO() {
	}

	public byte[] getIngredientJson() {
		return this.ingredientJson;
	}

	public void setIngredientJson(byte[] ingredientJson) {
		this.ingredientJson = ingredientJson;
	}

	public String getNomRecette() {
		return this.nomRecette;
	}

	public void setNomRecette(String nomRecette) {
		this.nomRecette = nomRecette;
	}

	public List<CommentaireDTO> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<CommentaireDTO> commentaires) {
		this.commentaires = commentaires;
	}

	public PaysDTO getPays() {
		return this.pays;
	}

	public void setPays(PaysDTO pays) {
		this.pays = pays;
	}

	public PersonneDTO getPersonne() {
		return this.personne;
	}

	public void setPersonne(PersonneDTO personne) {
		this.personne = personne;
	}

	/**
	 * @return the nbreCommentaire
	 */
	public int getNbreCommentaire() {
		return nbreCommentaire;
	}

	/**
	 * @param nbreCommentaire
	 *            the nbreCommentaire to set
	 */
	public void setNbreCommentaire(int nbreCommentaire) {
		this.nbreCommentaire = nbreCommentaire;
	}

	/**
	 * @return the idRecette
	 */
	public int getIdRecette() {
		return idRecette;
	}

	/**
	 * @param idRecette
	 *            the idRecette to set
	 */
	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

	/**
	 * @return the imageBase64
	 */
	public String getImageBase64() {
		return imageBase64;
	}

	/**
	 * @param imageBase64
	 *            the imageBase64 to set
	 */
	public void setImageBase64(String imageBase64) {
		this.imageBase64 = imageBase64;
	}

}