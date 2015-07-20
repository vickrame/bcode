/**
 * 
 */
package com.bcode.fwk.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

import com.bcode.fwk.GenericService;
import com.bcode.fwk.dto.CommentaireDTO;
import com.bcode.fwk.dto.PaysDTO;
import com.bcode.fwk.dto.PersonneDTO;
import com.bcode.fwk.dto.RecetteDTO;
import com.bcode.fwk.model.Commentaire;
import com.bcode.fwk.model.Pays;
import com.bcode.fwk.model.Personne;
import com.bcode.fwk.model.Recette;
import com.bcode.fwk.utils.ModelHelper;

/**
 * @author vickrame
 *
 */
@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RecetteService extends GenericService<Recette, RecetteDTO> {

	public static final String GET_ALL = "Recette.findAll";

	@Inject
	private PersonneService personneService;

	@Inject
	private PaysService paysService;

	@Inject
	private CommentaireService commentaireService;

	public RecetteService() {
		super(Recette.class);
	}

	public List<RecetteDTO> findListRecette(String nameQuery) {
		List<RecetteDTO> recetteDTO = new ArrayList<RecetteDTO>();
		RecetteDTO itemDTO;

		List<Recette> listRecette = super.findListEntityByNameQuery(nameQuery);

		for (Recette recette : listRecette) {
			itemDTO = transformModelToDTO(recette);
			recetteDTO.add(itemDTO);

		}

		return recetteDTO;
	}

	public RecetteDTO transformModelToDTO(Recette model) {
		RecetteDTO dto = new RecetteDTO();
		List<CommentaireDTO> listCommentaireDTO = new ArrayList<CommentaireDTO>();
		PaysDTO paysDTO;
		PersonneDTO personneDTO;

		personneDTO = new PersonneDTO();

		dto.setIdRecette(model.getIdRecette());
		dto.setNomRecette(model.getNomRecette());

		if (model.getPays() != null) {
			paysDTO = new PaysDTO();
			paysDTO.setCodePays(model.getPays().getCodePays());
			paysDTO.setLibelle(model.getPays().getLibelle());
			dto.setPays(paysDTO);
		}

		personneDTO = personneService.transformModelToDTO(model.getPersonne());

		if (model.getCommentaires() != null) {
			List<Commentaire> commentaireList = model.getCommentaires();
			for (Commentaire commenatire : commentaireList) {
				listCommentaireDTO.add(commentaireService
						.transformModelToDTO(commenatire));
			}

			dto.setCommentaires(listCommentaireDTO);
		}

		dto.setPersonne(personneDTO);

		return dto;
	}

	/**
	 * 
	 * @param dto
	 */
	public void create(RecetteDTO dto) {
		Recette model = new Recette();

		Pays pays = null;
		Personne personne = null;
		Map<String, Object> paramPays = new HashMap<String, Object>();
		paramPays.put(ModelHelper.PAYS_CODE, dto.getPays().getCodePays());

		pays = paysService.findUniqueEntityByNameQuery(
				PaysService.GET_COUNTRY_BY_CODE, paramPays);

		paramPays.clear();

		paramPays.put(ModelHelper.PERSONNE_EMAIL, dto.getPersonne().getEmail());

		personne = personneService.findUniqueEntityByNameQuery(
				PersonneService.FIND_BY_EMAIL, paramPays);

		model.setNomRecette(dto.getNomRecette());
		model.setPays(pays);
		model.setPersonne(personne);

		/**
		 * TEST
		 */

		File f = new File("c:\\logos\\test.png");
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			byte[] t = IOUtils.toByteArray(in);
			model.setImage(t);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		super.create(model);

	}

	/**
	 * 
	 * @param dto
	 */
	public void update(RecetteDTO dto) {
		Recette model = new Recette();

		super.update(model);

	}

	public RecetteDTO getDetail(final int id) {
		RecetteDTO dto = null;// new RecetteDTO();
		Recette recette = super.findById(id);

		// chargement
		recette.getCommentaires();

		dto = transformModelToDTO(recette);
		dto.setImageBase64(Base64.encodeBase64String(recette.getImage()));

		return dto;
	}

}
