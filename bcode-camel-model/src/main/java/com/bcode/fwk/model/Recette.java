package com.bcode.fwk.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * 
 * @author vickrame
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Recette.findAll", query = "SELECT r FROM Recette r left join r.pays p left join r.personne pers")
// @NamedQuery(name = "Recette.findAll", query = "SELECT r FROM Recette r")
})
public class Recette implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RECETTE", updatable = false)
	private int idRecette;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "INGREDIENT_JSON")
	private byte[] ingredientJson;

	@Column(name = "NOM_RECETTE")
	private String nomRecette;

	@OneToMany(mappedBy = "recette")
	private List<Commentaire> commentaires;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_PAYS")
	private Pays pays;

	@ManyToOne
	@JoinColumn(name = "ID_PERSONNE")
	private Personne personne;

	public Recette() {
	}

	public int getIdRecette() {
		return this.idRecette;
	}

	public void setIdRecette(int idRecette) {
		this.idRecette = idRecette;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
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

	public List<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Pays getPays() {
		return this.pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Recette [idRecette=").append(idRecette)
				.append(", nomRecette=").append(nomRecette).append(", pays=")
				.append(pays).append("]");
		return builder.toString();
	}

}