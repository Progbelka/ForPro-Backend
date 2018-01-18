package de.hszg.stud.svtsar.forpro_backend.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.hszg.stud.svtsar.forpro_backend.entity.Store;
import de.hszg.stud.svtsar.forpro_backend.repository.Store_rep;

@Path("stores")
public class StoreResource {
	
	@Inject 
	private Store_rep storeRepository;
	
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Store> stores = storeRepository.getAll();
		return Response.ok(stores).build();
	}
}
