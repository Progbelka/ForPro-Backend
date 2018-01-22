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

import de.hszg.stud.svtsar.forpro_backend.entity.Product;
import de.hszg.stud.svtsar.forpro_backend.entity.ProductInStock;
import de.hszg.stud.svtsar.forpro_backend.repository.ProductInStock_rep;

@Path("productInStock")
public class ProductInstockResurce {
	@Inject
	private ProductInStock_rep productInStockRepository;
	
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<ProductInStock> productInStock = productInStockRepository.getAll();
		return Response.ok(productInStock).build();
	}
	
	@PUT
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(ProductInStock productInStock) {
		try {
			productInStockRepository.create(productInStock);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(ProductInStock productInStock) {
		try {
			productInStockRepository.delete(productInStock);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(ProductInStock productInstock) {
		try {
			productInStockRepository.update(productInstock);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}

}
