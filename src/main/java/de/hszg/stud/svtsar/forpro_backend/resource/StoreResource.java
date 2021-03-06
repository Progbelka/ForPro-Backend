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
	
	@PUT
	@Path("create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Store store) {
		try {
			storeRepository.create(store);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	
	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(Store store) {
		try {
			storeRepository.delete(store);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}
	@POST
	@Path("update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Store store) {
		try {
			storeRepository.update(store);
			return Response.ok().build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Status.BAD_REQUEST).entity(e.getMessage()).build();
		}
		
	}

}
