package de.hszg.stud.svtsar.forpro_backend.resource;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hszg.stud.svtsar.forpro_backend.entity.ProductInStore;
import de.hszg.stud.svtsar.forpro_backend.repository.ProductInStore_rep;

@Path("productInStore")
public class ProductInStoreResource {
	@Inject
	private ProductInStore_rep productInStoreRepository;
	
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<ProductInStore> productInstore = productInStoreRepository.getAll();
		return Response.ok(productInstore).build();
	}
}
