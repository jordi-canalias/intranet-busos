package api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import service.ServiceManager;

@Path("/parada")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")

public class ParadaApi {
	
	private ServiceManager service;
	
	public ParadaApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
	 * 
		GET totesParadas ==> {"/"}
		GET paradaById ==> {"/id"}
		GET paradaByNom ==> {"/nom"}
		POST updateParada ==> {"/id"}
		PUT setParada ==> {"/"}
		DELETE borraParada ==> {"/id"}

	 */
	
	
	@GET
	@Path("/")
	public Response totesParadas() {
		
		ArrayList<Parada> pa = service.getParadasServ();
		
		return Response.ok(pa, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/id/{id}")
	public Response getParadaByid(@PathParam("id") int id) {
		return Response.ok(service.GetParadasByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/nom/{nom}")
	public Response getParadasByNom(@PathParam("nom") String nom) {
		return Response.ok(service.getParadasByNomServ(nom), MediaType.APPLICATION_JSON).build();
	}
	
	
	@PUT
	@Path("/inserta")
	public Response insertaParada(Parada pa) {	
		service.insertaParadaServ(pa);
		return Response.ok("Parada Insertada",MediaType.APPLICATION_JSON).build();
	}
	
	
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteParada(@PathParam("id") int id) {
		service.deleteParadaServ(id);
		return Response.ok("Esborrat correctament", MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	@PUT
	@Path("/actualitza/{id}")

	public Response updateParada(Parada pa,@PathParam("id") int id) {                                        
		
		service.actualitzaParadaServ(pa,id);
		
		return Response.ok("Modificat correctement",MediaType.APPLICATION_JSON).build();
	}
	
	//----------final above------
	

	
	
}