package api;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.*;
import service.ServiceManager;

@Path("/resenyas")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")

public class ResenyasApi {
	
	private ServiceManager service;
	
	public ResenyasApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
	 * 
	    GET totesResenyas ==> {"/"}    check
		GET resenyaById==> {"/id"}     check
		GET resenyasByUsuario ==> {"/user"}   check
		GET resenyaByFecha ==> {"/fecha"}
		GET resenyasHastag ==> {"/"}  (La meva idea es que amb aquest sistema puguis etiquetar cada reseña com a una escola una excursio on lloc concret una regio)
		POST actualizaResenya ==> {"/id"} check
		PUT insertaresenya ==> {"/"} check
		DELETE borraResenya ==> {"/id"} 

	 */
	
	
	@GET
	@Path("/")
	public Response totesResenyas() {
		return Response.ok(service.getResenyasServ(), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/id/{id}")
	public Response getResenyaByid(@PathParam("id") int id) {
		return Response.ok(service.GetResenyasByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/nom/{nom}")
	public Response getResenyaByNom(@PathParam("nom") String nom) {
		return Response.ok(service.GetResenyasByNomServ(nom), MediaType.APPLICATION_JSON).build();
	}
	
	
	@POST
	@Path("/inserta")
	public Response insertresenya(Resenya res) {	
		
		Resenya val = service.insertResenyaServ(res);
		return Response.ok(val,MediaType.APPLICATION_JSON).build();
	}
	
	
	@PUT
	@Path("/actualitza/{id}")
	public Response actualitzaUser(Resenya res,@PathParam("id") int id) {                                      
		
		service.actualitzaResenyaServ(res,id);
		Resenya rese = service.GetResenyasByIdServ(id);
		
		return Response.ok(rese,MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteResenya(@PathParam("id") int id) {
		
		service.deleteResenyaServ(id);
		return Response.ok("Esborrat correctament", MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	//----------final above------
	
	
	
	
	
}