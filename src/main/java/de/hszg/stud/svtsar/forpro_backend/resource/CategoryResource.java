package de.hszg.stud.svtsar.forpro_backend.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hszg.stud.svtsar.forpro_backend.entity.Category;
import de.hszg.stud.svtsar.forpro_backend.repository.Category_rep;

@Path("category")
public class CategoryResource {
	
	@Inject 
	private Category_rep categoryRepository;
	
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Category> categories = categoryRepository.getAll();
		return Response.ok(categories).build();
	}

}
