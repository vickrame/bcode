package com.bcode.fwk.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author vickrame
 *
 */
public class PersonneDTO extends AbstractDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private String email;

	private String nom;

	private String prenom;

	private List<CommentaireDTO> commentaires =new ArrayList<CommentaireDTO>();

	private List<PersonneRoleDTO> personneRoles= new ArrayList<PersonneRoleDTO>();

	private List<RecetteDTO> recettes =new ArrayList<RecetteDTO>();

	public PersonneDTO() {
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

	public List<CommentaireDTO> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(List<CommentaireDTO> commentaires) {
		this.commentaires = commentaires;
	}


	public List<PersonneRoleDTO> getPersonneRoles() {
		return this.personneRoles;
	}

	public void setPersonneRoles(List<PersonneRoleDTO> personneRoles) {
		this.personneRoles = personneRoles;
	}


	public List<RecetteDTO> getRecettes() {
		return this.recettes;
	}

	public void setRecettes(List<RecetteDTO> recettes) {
		this.recettes = recettes;
	}


}