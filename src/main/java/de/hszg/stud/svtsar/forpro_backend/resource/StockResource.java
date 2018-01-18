package de.hszg.stud.svtsar.forpro_backend.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;


import de.hszg.stud.svtsar.forpro_backend.entity.Stock;
import de.hszg.stud.svtsar.forpro_backend.repository.Stock_rep;

@Path("stocks")
public class StockResource {

	@Inject
	private Stock_rep stockRepository;
	
	@GET
	@Path("getAll")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		List<Stock> stock = stockRepository.getAll();
		return Response.ok(stock).build();
	}
	
	@GET
	@Path("findById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response find(@QueryParam("id") int id) {
		Stock stock = stockRepository.find(id);
		return Response.ok(stock).build();
	}
}
