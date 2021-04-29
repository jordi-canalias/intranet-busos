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
		POST actualizaResenya ==> {"/id"}
		PUT insertaresenya ==> {"/"}
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
	
	
	@PUT
	@Path("/inserta")
	public Response insertresenya(Resenya res) {	
		
		Boolean val = service.insertResenyaServ(res);
		return Response.ok("Resenya Insertada",MediaType.APPLICATION_JSON).build();
	}
	
	
	@PUT
	@Path("/actualitza/{id}")
	public Response actualitzaUser(Resenya res,@PathParam("id") int id) {                                        //comproba el token del usuari
		
		service.actualitzaResenyaServ(res,id);
		
		return Response.ok("Modificat correctement",MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	//----------final above------
	
	
	
	
	
	
	
	
	
	
	
	@PUT
	@Path("/actualitza/{nom}")
	public Response putUser(Usuari us,@PathParam("nom") String nom) {                                        //comproba el token del usuari
		
		service.actualitzaUsuariServ(us,nom);
		
		return Response.ok("Modificat correctement",MediaType.APPLICATION_JSON).build();
	}
	
	
	
	@PUT
	@Path("/login")
	public Response logUser(Usuari us) {										//logeja i actualitza el token del usuari 
		
		Boolean res = service.checkUsuariServ(us);
		String token ="error";
		
		if(res == true) {
			token = service.tokenGen();
			service.actualitzaToken(token,us);
		}
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(token);
		
		//return Response.ok(arr ,MediaType.APPLICATION_JSON).build();
		return Response.ok(arr ,MediaType.APPLICATION_JSON).build();
	}
	
	
	@PUT
	@Path("/check")
	public Response checkToken(Token to) {                                        //comproba el token del usuari
		
		Boolean Check = service.checkToken(to);
		
		ArrayList<Boolean> arr = new ArrayList<Boolean>();
		arr.add(Check);
		
		return Response.ok(arr ,MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("/registra")
	public Response putUser(Usuari us) {                                        //comproba el token del usuari
		
		Boolean creacio = service.setUsuariServ(us);
		
		return Response.ok(creacio ,MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	@DELETE
	@Path("delete/{nom}")
	public Response deleteUsuari(@PathParam("nom") String nom) {
		
		service.deleteUsuariServ(nom);
		return Response.ok("Esborrat correctament", MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	
	
	
	
	
	
}