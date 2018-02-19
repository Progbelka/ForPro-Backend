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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import de.hszg.stud.svtsar.forpro_backend.entity.Product;
import de.hszg.stud.svtsar.forpro_backend.repository.Product_rep;

@Path("products")
public class ProductResource {

	@Inject
	private Product_rep productRepository;

	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Product> products = productRepository.getAll();
		return Response.ok(products).build();
	}
	
	@PUT
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Product product) {
		try {
			productRepository.create(product);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(Product product) {
		try {
			productRepository.delete(product);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Product product) {
		try {
			productRepository.update(product);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}

	@GET
	@Path("findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@QueryParam("id") int id) {
		Product product = productRepository.find(id);
		return Response.ok(product).build();
	}
	
	@GET
	@Path("findByName")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@QueryParam("name") String name) {
		Product product = productRepository.findByName(name);
		return Response.ok(product).build();
	}
	
	@GET
	@Path("deleteById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("id") int id){
		Product product = productRepository.find(id);
		productRepository.delete(product);
		return Response.ok(product).build();
	}
}
