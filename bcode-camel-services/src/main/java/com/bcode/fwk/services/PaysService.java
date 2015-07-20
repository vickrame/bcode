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
import com.bcode.fwk.dto.PaysDTO;
import com.bcode.fwk.model.Pays;
import com.bcode.fwk.utils.ModelHelper;

/**
 * @author vickrame
 *
 */
@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PaysService extends GenericService<Pays, PaysDTO> {

	public static final String GET_ALL = "Pays.findAll";
	public static final String GET_COUNTRY_BY_CODE = "Pays.findPaysByCode";

	public PaysService() {
		super(Pays.class);
	}

	/**
	 * 
	 * @param nameQuery
	 * @return
	 */
	public List<PaysDTO> findListEntity(String nameQuery) {

		System.out.println("logger " + logger);

		List<Pays> entiteList = super.findListEntityByNameQuery(nameQuery);
		List<PaysDTO> ret = new ArrayList<PaysDTO>();

		PaysDTO item = null;

		for (Pays model : entiteList) {

			item = transformModelToDTO(model);

			ret.add(item);
		}
		return ret;
	}

	/**
	 * 
	 * @param model
	 * @param dto
	 */
	public PaysDTO transformModelToDTO(Pays model) {

		PaysDTO dto = new PaysDTO();
		dto.setIdPays(model.getIdPays());
		dto.setCodePays(model.getCodePays());
		dto.setLibelle(model.getLibelle());

		return dto;
	}

	/**
	 * 
	 * @param dto
	 */
	public void create(PaysDTO dto) {
		Pays model = new Pays();

		model.setCodePays(dto.getCodePays());
		model.setLibelle(dto.getLibelle());
		// model.setPrenom(dto.getPrenom());

		super.create(model);

	}

	/**
	 * 
	 * @param dto
	 */
	public void updateModel(PaysDTO dto) {
		Pays model = new Pays();

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ModelHelper.PAYS_CODE, dto.getCodePays());

		model = super.findUniqueEntityByNameQuery(
				PaysService.GET_COUNTRY_BY_CODE, param);

		model.setLibelle(dto.getLibelle());

		super.update(model);
	}

}
