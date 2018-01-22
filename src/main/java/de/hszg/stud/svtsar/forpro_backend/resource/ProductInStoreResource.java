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
	
	@PUT
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(ProductInStore productInStore ) {
		try {
			productInStoreRepository.create(productInStore);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(ProductInStore productInStore) {
		try {
			productInStoreRepository.delete(productInStore);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(ProductInStore productInStore) {
		try {
			productInStoreRepository.update(productInStore);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}

}
