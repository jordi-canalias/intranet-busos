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

@Path("/usuaris")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")

public class UsuariApi {
	
	private ServiceManager service;
	
	public UsuariApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
	 * GET totsUsuaris ==> {"/"}  chech
	GET usuariById ==> {"/id"}	check
	GET usuarisByFuncio ==> {"/funcio"}  check
	GET getUsuariosOrdenEntrada ==> {"/"}
	PUT checkUsuari ==> {"/login"} check
	PUT setUsuario ==> {"/"}   check
	POST updateUsuario ==> {"/id"}  check
	DELETE borraUsuario ==> {"/id"} check
	 */
	
	
	@GET
	@Path("/")
	public Response getUsuaris() {
		return Response.ok(service.getUsuarisServ(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("funcio/{fun}")
	public Response getRutaByUsuari(@PathParam("fun") String fun) {
		return Response.ok(service.getUsuarisPerFuncioServ(fun), MediaType.APPLICATION_JSON).build();
	}
	
	
	
	@PUT
	@Path("/actualitza/{nom}")

	public Response putUser(Usuari us,@PathParam("nom") String nom) {                                        
		
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
	public Response putUser(Usuari us) {                                        
		
		Boolean creacio = service.setUsuariServ(us);
		
		return Response.ok(creacio ,MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	@DELETE
	@Path("delete/{nom}")
	public Response deleteUsuari(@PathParam("nom") String nom) {
		
		service.deleteUsuariServ(nom);
		return Response.ok("Esborrat correctament", MediaType.APPLICATION_JSON).build();
	}
	
	
	
	

	/*
	 * 
	 * 
	 * 26/04/2021
	 * 
	@GET
	@Path("{id}")
	public Response getUsuariById(@PathParam("id") int id) {
		return Response.ok(service.getUsuariByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
>>>>>>> e3d1b8f72209f681ece5aba0747f2cf45489845c
	
	*/
	
	
	
}