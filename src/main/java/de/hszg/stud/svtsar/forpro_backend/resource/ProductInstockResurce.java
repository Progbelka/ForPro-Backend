package de.hszg.stud.svtsar.forpro_backend.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
