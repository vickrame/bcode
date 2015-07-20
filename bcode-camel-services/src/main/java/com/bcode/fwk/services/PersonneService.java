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

import com.bcode.fwk.GenericService;
import com.bcode.fwk.dto.PersonneDTO;
import com.bcode.fwk.model.Personne;
import com.bcode.fwk.utils.ModelHelper;

/**
 * @author vickrame
 *
 */
@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonneService extends GenericService<Personne, PersonneDTO> {

	public static final String GET_ALL = "Personne.findAll";
	public static final String FIND_BY_EMAIL = "Personne.findByEmail";

	public PersonneService() {
		super(Personne.class);
	}

	/**
	 * 
	 * @param nameQuery
	 * @return
	 */
	public List<PersonneDTO> findListEntity(String nameQuery) {

		System.out.println("logger " + logger);

		List<Personne> entiteList = super.findListEntityByNameQuery(nameQuery);
		List<PersonneDTO> ret = new ArrayList<PersonneDTO>();

		PersonneDTO item = null;
		// CommentaireDTO commentaireDTO = null;;
		// RecetteDTO recetteDTO = null;

		for (Personne personne : entiteList) {

			item = transformModelToDTO(personne);

			// for (Commentaire commentaire : personne.getCommentaires()) {
			// commentaireDTO = new CommentaireDTO();
			// commentaireDTO.setDescription(commentaire.getDescription());
			// commentaireDTO.setPersonne(comm);
			// };
			//
			// personne.getPersonneRoles();
			// personne.getRecettes();
			ret.add(item);
		}
		return ret;
	}

	/**
	 * 
	 * @param model
	 * @param dto
	 */
	public PersonneDTO transformModelToDTO(Personne model) {
		PersonneDTO dto = new PersonneDTO();
		dto.setEmail(model.getEmail());
		dto.setNom(model.getNom());
		dto.setPrenom(model.getPrenom());

		return dto;
	}

	/**
	 * 
	 * @param dto
	 */
	public void create(PersonneDTO dto) {
		Personne model = new Personne();

		model.setEmail(dto.getEmail());
		model.setNom(dto.getNom());
		model.setPrenom(dto.getPrenom());

		super.create(model);

	}

	/**
	 * 
	 * @param dto
	 */
	public void update(PersonneDTO dto) {
		Personne model = new Personne();

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ModelHelper.PERSONNE_EMAIL, dto.getEmail());

		model = super.findUniqueEntityByNameQuery(
				PersonneService.FIND_BY_EMAIL, param);

		fetchPersonne(model);

		model.setNom(dto.getNom());
		model.setPrenom(dto.getPrenom());

		super.update(model);

	}

	/**
	 * @param model
	 */
	private void fetchPersonne(Personne model) {
		model.getCommentaires();
		model.getPersonneRoles();
		model.getRecettes();
	}

}