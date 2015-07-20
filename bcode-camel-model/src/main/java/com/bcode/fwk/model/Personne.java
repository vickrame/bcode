package com.bcode.fwk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * 
 * @author vickrame
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Personne.findAll", query = "SELECT p FROM Personne p"),
		@NamedQuery(name = "Personne.findByEmail", query = "SELECT p FROM Personne p where p.email= :email") })
public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_PERSONNE", updatable = false)
	private int idPersonne;

	@Column(updatable = false)
	private String email;

	private String nom;

	private String prenom;

	@OneToMany(mappedBy = "personne", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<Commentaire> commentaires = null;

	@OneToMany(mappedBy = "personne", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<PersonneRole> personneRoles = null;

	@OneToMany(mappedBy = "personne", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE }, fetch = FetchType.LAZY)
	private List<Recette> recettes = null;

	public Personne() {
	}

	public int getIdPersonne() {
		return this.idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public List<Commentaire> getCommentaires() {
		if (this.commentaires == null || (this.commentaires.isEmpty()))
			this.commentaires = new ArrayList<Commentaire>();
		return this.commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public List<PersonneRole> getPersonneRoles() {
		if (this.personneRoles == null || (this.personneRoles.isEmpty()))
			this.personneRoles = new ArrayList<PersonneRole>();

		return this.personneRoles;
	}

	public void setPersonneRoles(List<PersonneRole> personneRoles) {
		this.personneRoles = personneRoles;
	}

	public List<Recette> getRecettes() {
		if (this.recettes == null || (this.recettes.isEmpty()))
			this.recettes = new ArrayList<Recette>();

		return this.recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Personne [idPersonne=").append(idPersonne)
				.append(", email=").append(email).append(", nom=").append(nom)
				.append(", prenom=").append(prenom).append("]");
		return builder.toString();
	}

}