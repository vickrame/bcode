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



/**
 * 
 * @author vickrame
 *
 */
@Entity
@NamedQuery(name="Commentaire.findAll", query="SELECT c FROM Commentaire c")
public class Commentaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMMENTAIRE", updatable=false)
	private int idCommentaire;

	private String description;

	@ManyToOne
	@JoinColumn(name="ID_PERSONNE")
	private Personne personne;

	@ManyToOne
	@JoinColumn(name="ID_RECETTE")
	private Recette recette;

	public Commentaire() {
	}

	public int getIdCommentaire() {
		return this.idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public Recette getRecette() {
		return this.recette;
	}

	public void setRecette(Recette recette) {
		this.recette = recette;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commentaire [idCommentaire=").append(idCommentaire)
				.append(", description=").append(description).append("]");
		return builder.toString();
	}

}