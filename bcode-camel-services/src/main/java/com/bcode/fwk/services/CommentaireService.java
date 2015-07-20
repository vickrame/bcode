/**
 * 
 */
package com.bcode.fwk.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.bcode.fwk.GenericService;
import com.bcode.fwk.dto.CommentaireDTO;
import com.bcode.fwk.dto.PersonneDTO;
import com.bcode.fwk.model.Commentaire;
import com.bcode.fwk.model.Personne;
import com.bcode.fwk.utils.ModelHelper;

/**
 * @author vickrame
 *
 */
@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CommentaireService extends
		GenericService<Commentaire, CommentaireDTO> {

	public static final String GET_ALL = "Commentaire.findAll";

	@Inject
	private PersonneService personneService;

	// @Inject
	// private RecetteService recetteService;

	public CommentaireService() {
		super(Commentaire.class);
	}

	/**
	 * 
	 * @param nameQuery
	 * @return
	 */
	public List<CommentaireDTO> findListCommentaire(String nameQuery) {
		List<CommentaireDTO> commentaireDTO = new ArrayList<CommentaireDTO>();
		CommentaireDTO itemDTO = null;
		List<Commentaire> listCommentaire = super
				.findListEntityByNameQuery(nameQuery);

		for (Commentaire commentaire : listCommentaire) {
			itemDTO = transformModelToDTO(commentaire);
			commentaireDTO.add(itemDTO);

		}

		return commentaireDTO;
	}

	/**
	 * 
	 * @param model
	 * @param dto
	 */
	public CommentaireDTO transformModelToDTO(Commentaire model) {

		CommentaireDTO dto = new CommentaireDTO();

		dto.setDescription(model.getDescription());
		PersonneDTO personneDTO = personneService.transformModelToDTO(model
				.getPersonne());

		dto.setPersonne(personneDTO);

		return dto;
	}

	/**
	 * 
	 * @param dto
	 */
	public void create(CommentaireDTO dto) {
		Commentaire model = new Commentaire();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put(ModelHelper.PERSONNE_EMAIL, dto.getPersonne().getEmail());

		Personne personneModel = personneService.findUniqueEntityByNameQuery(
				PersonneService.FIND_BY_EMAIL, params);

		// Recette recetteModel = recetteService.findById(dto.getRecette()
		// .getIdRecette());

		// List<Commentaire> listCommentaire = recetteModel.getCommentaires();
		// if (listCommentaire == null) {
		// listCommentaire = new ArrayList<Commentaire>();
		// }

		// model.setRecette(recetteModel);
		model.setPersonne(personneModel); // ajout de la personne qui a ecrit le
											// commentaire
		model.setDescription(dto.getDescription());
		// listCommentaire.add(model); // ajout du commentaire dans la liste des
		// recette

		// recetteService.update(recetteModel); // mise à jour de la recette.

	}

	/**
	 * 
	 * @param dto
	 */
	public void updateModel(CommentaireDTO dto) {
		Commentaire model = findById(dto.getIdCommentaire());
		model.setDescription(dto.getDescription());

		super.update(model);

	}

}