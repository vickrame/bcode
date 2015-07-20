/**
 * 
 */
package com.bcode.fwk.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bcode.fwk.dto.CommentaireDTO;
import com.bcode.fwk.services.CommentaireService;

/**
 * @author vickrame
 *
 */
@Path("commentaire")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class CommentaireAPI {

	@Inject
	private CommentaireService commentaireService;

	@GET
	@Path("/all")
	public List<CommentaireDTO> getCmmentaires() {
		List<CommentaireDTO> ret = commentaireService
				.findListCommentaire(CommentaireService.GET_ALL);
		return ret;
	}

	@POST
	public CommentaireDTO create(CommentaireDTO dto) {
		commentaireService.create(dto);
		return dto;
	}

	@PUT
	public CommentaireDTO update(CommentaireDTO dto) {
		commentaireService.updateModel(dto);
		return dto;
	}
}
