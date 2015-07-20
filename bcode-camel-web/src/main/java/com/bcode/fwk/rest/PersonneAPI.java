/**
 * 
 */
package com.bcode.fwk.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bcode.fwk.dto.PersonneDTO;
import com.bcode.fwk.services.PersonneService;
import com.bcode.fwk.services.TestService;
import com.bcode.fwk.utils.ModelHelper;

/**
 * @author vickrame
 *
 */
@Path("personne")
@RequestScoped
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PersonneAPI {

	@Inject
	private PersonneService personneService;

	@EJB
	private TestService testService;

	public PersonneAPI() {
	}

	@GET
	@Path("/all")
	public List<PersonneDTO> getPersonne() {
		List<PersonneDTO> ret = personneService
				.findListEntity(PersonneService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/{email}")
	public PersonneDTO getDetailPersonne(@PathParam("email") String email) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ModelHelper.PERSONNE_EMAIL, email);

		PersonneDTO ret = personneService.findEntity(
				PersonneService.FIND_BY_EMAIL, param);
		return ret;
	}

	@POST
	public PersonneDTO create(PersonneDTO dto) {
		personneService.create(dto);
		return dto;
	}

	@PUT
	public PersonneDTO update(PersonneDTO dto) {
		personneService.update(dto);
		return dto;
	}

}
