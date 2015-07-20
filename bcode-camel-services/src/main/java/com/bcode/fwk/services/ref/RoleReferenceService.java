/**
 * 
 */
package com.bcode.fwk.services.ref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.bcode.fwk.GenericService;
import com.bcode.fwk.dto.RoleRefDTO;
import com.bcode.fwk.model.RoleRef;
import com.bcode.fwk.utils.ModelHelper;

/**
 * @author vickrame
 *
 */
@LocalBean
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class RoleReferenceService extends GenericService<RoleRef, RoleRefDTO> {

	public static final String GET_ALL = "RoleRef.findAll";
	public static final String GET_BY_CODE = "RoleRef.findByCode";

	public RoleReferenceService() {
		super(RoleRef.class);
	}

	/**
	 * 
	 * @param nameQuery
	 * @return
	 */
	public List<RoleRefDTO> findListEntity(String nameQuery) {

		System.out.println("logger " + logger);
		logger.info("coucu");
		List<RoleRef> entiteList = super.findListEntityByNameQuery(nameQuery);
		List<RoleRefDTO> ret = new ArrayList<RoleRefDTO>();

		RoleRefDTO item = new RoleRefDTO();

		for (RoleRef model : entiteList) {

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
	public RoleRefDTO transformModelToDTO(RoleRef model) {
		RoleRefDTO dto = new RoleRefDTO();
		dto.setIdRole(model.getIdRole());
		dto.setCodeRole(model.getCodeRole());
		dto.setLibelle(model.getLibelle());

		return dto;
	}

	/**
	 * 
	 * @param dto
	 */
	public void create(RoleRefDTO dto) {
		RoleRef model = new RoleRef();

		model.setCodeRole(dto.getCodeRole());
		model.setLibelle(dto.getLibelle());
		// model.setPrenom(dto.getPrenom());

		super.create(model);

	}

	/**
	 * 
	 * @param dto
	 */
	public void updateModel(RoleRefDTO dto) {
		RoleRef model = new RoleRef();

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ModelHelper.ROLE_CODE, dto.getCodeRole());

		model = super.findUniqueEntityByNameQuery(
				RoleReferenceService.GET_BY_CODE, param);

		model.setLibelle(dto.getLibelle());

		super.update(model);
	}
}
