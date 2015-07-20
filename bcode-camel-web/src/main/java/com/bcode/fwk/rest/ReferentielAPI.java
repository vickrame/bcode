/**
 * 
 */
package com.bcode.fwk.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bcode.fwk.dto.PaysDTO;
import com.bcode.fwk.dto.RoleRefDTO;
import com.bcode.fwk.services.PaysService;
import com.bcode.fwk.services.ref.RoleReferenceService;
import com.bcode.fwk.utils.ModelHelper;

/**
 * @author vickrame
 *
 */
@Path("referentiel")
public class ReferentielAPI {

	@Inject
	private PaysService payService;

	@Inject
	private RoleReferenceService roleReferenceService;

	@GET
	@Path("/pays/all")
	public List<PaysDTO> getAllPays() {
		List<PaysDTO> ret = payService.findListEntity(PaysService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/pays/{code}")
	public PaysDTO getPays(@PathParam("code") String code) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ModelHelper.PAYS_CODE, code);

		PaysDTO ret = payService.findEntity(PaysService.GET_COUNTRY_BY_CODE,
				param);
		return ret;
	}

	@GET
	@Path("/roles/all")
	public List<RoleRefDTO> getAllRoleRef() {
		List<RoleRefDTO> ret = roleReferenceService
				.findListEntity(RoleReferenceService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/roles/{code}")
	public RoleRefDTO getRoleRefByCode(@PathParam("code") String code) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ModelHelper.ROLE_CODE, code);

		RoleRefDTO ret = roleReferenceService.findEntity(
				RoleReferenceService.GET_BY_CODE, param);
		return ret;
	}

	@POST
	@Path("/pays")
	public PaysDTO create(PaysDTO dto) {
		payService.create(dto);
		return dto;
	}

	@PUT
	@Path("/pays")
	public PaysDTO update(PaysDTO dto) {
		payService.updateModel(dto);
		return dto;
	}

	@POST
	@Path("/roles")
	public RoleRefDTO create(RoleRefDTO dto) {
		roleReferenceService.create(dto);
		return dto;
	}

	@PUT
	@Path("/roles")
	public RoleRefDTO update(RoleRefDTO dto) {
		roleReferenceService.updateModel(dto);
		return dto;
	}
}
