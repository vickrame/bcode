/**
 * 
 */
package com.bcode.fwk.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.bcode.fwk.dto.RecetteDTO;
import com.bcode.fwk.services.RecetteService;

/**
 * @author vickrame
 *
 */
@Path("recette")
public class RecetteAPI {

	@Inject
	private RecetteService recetteService;

	@GET
	@Path("/all")
	public List<RecetteDTO> getPersonne() {
		List<RecetteDTO> ret = recetteService
				.findListRecette(RecetteService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/detail/{id}")
	public RecetteDTO getDetail(@PathParam("id") int id) {
		RecetteDTO ret = recetteService.getDetail(id);
		return ret;
	}

	@POST
	public RecetteDTO create(RecetteDTO dto) {
		recetteService.create(dto);
		return dto;
	}

	@PUT
	public RecetteDTO update(RecetteDTO dto) {
		recetteService.update(dto);
		return dto;
	}

}
