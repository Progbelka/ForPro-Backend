package de.hszg.stud.svtsar.forpro_backend.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hszg.stud.svtsar.forpro_backend.entity.Category;
import de.hszg.stud.svtsar.forpro_backend.entity.Product;
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
	
	@PUT
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Category category) {
		try {
			categoryRepository.create(category);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(Category category) {
		try {
			categoryRepository.delete(category);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Category category) {
		try {
			categoryRepository.update(category);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}


}
