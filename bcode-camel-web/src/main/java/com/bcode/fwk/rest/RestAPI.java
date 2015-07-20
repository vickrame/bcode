/**
 * 
 */
package com.bcode.fwk.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bcode.fwk.camel.context.CamelService;
import com.bcode.fwk.dto.CommentaireDTO;
import com.bcode.fwk.dto.PersonneDTO;
import com.bcode.fwk.dto.RecetteDTO;
import com.bcode.fwk.model.Pays;
import com.bcode.fwk.model.RoleRef;
import com.bcode.fwk.services.CommentaireService;
import com.bcode.fwk.services.PaysService;
import com.bcode.fwk.services.PersonneService;
import com.bcode.fwk.services.RecetteService;
import com.bcode.fwk.services.ref.RoleReferenceService;

/**
 * @author vickrame
 *
 */
@Path("api")
// @ApplicationPath("/rest")
// @Stateless
@RequestScoped
// @Stateless
// @Api(description="destion des api rest avec swagger",consumes="Cette api prend en entrée un flux au format JSON.",
// value="/api")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class RestAPI {// extends AbstractBase {//extends Application {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6674570396384574878L;

	@Inject
	private CamelService camelService;

	@Inject
	private PersonneService personneService;

	@Inject
	private PaysService paysService;

	@Inject
	private RoleReferenceService roleReferenceService;

	@Inject
	private CommentaireService commentaireService;

	@Inject
	private RecetteService recetteService;

	@GET
	@Path("/camel")
	public String appelCamel() {
		System.out.println("sdfdfd");
		camelService.test();
		camelService.startCamel("123456789");
		return "tot";
	}

	@GET
	@Path("/personne")
	public List<PersonneDTO> getPersonne() {
		List<PersonneDTO> ret = personneService
				.findListEntity(PersonneService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/pays")
	public List<Pays> getAllPays() {
		List<Pays> ret = paysService
				.findListEntityByNameQuery(PaysService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/recette")
	public List<RecetteDTO> getAllRecette() {
		List<RecetteDTO> ret = recetteService
				.findListRecette(RecetteService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/roles")
	public List<RoleRef> getAllRoles() {
		List<RoleRef> ret = roleReferenceService
				.findListEntityByNameQuery(RoleReferenceService.GET_ALL);
		return ret;
	}

	@GET
	@Path("/commentaires")
	public List<CommentaireDTO> getAllCommentaires() {
		List<CommentaireDTO> ret = commentaireService
				.findListCommentaire(CommentaireService.GET_ALL);
		return ret;
	}
}
