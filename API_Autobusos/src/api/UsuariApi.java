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
	@Path("id/{id}")
	public Response getUserById(@PathParam("id") int id) {
		return Response.ok(service.getUsuariPerIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("nombre/{nombre}")
	public Response getUserById(@PathParam("nombre") String nombre) {
		return Response.ok(service.getUserByNomServ(nombre), MediaType.APPLICATION_JSON).build();
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
		Usuari usu = service.getUserByNomServ(nom);
		
		return Response.ok(usu,MediaType.APPLICATION_JSON).build();
	}
	
	
	
	@PUT
	@Path("/login")
	public Response logUser(Usuari us) {										//logeja i actualitza el token del usuari 
		
		Boolean res = service.checkUsuariServ(us);
		String token ="no asignat";
		
		if(res == true) {
			token = service.tokenGen();
			service.actualitzaToken(token,us);  //le paso el token generado aleatoriamente y el nombre y contrasenya del usuario
		}
		
		ArrayList<String> arr = new ArrayList<String>();
		arr.add(token);
		
		Missatge mis = new Missatge(token);
		
		//return Response.ok(arr ,MediaType.APPLICATION_JSON).build();
		return Response.ok(mis ,MediaType.APPLICATION_JSON).build();
	}
	
	
	@PUT
	@Path("/check")
	public Response checkToken(Token to) {                                        //comproba el token del usuari
		
		Boolean Check = service.checkToken(to);
		ArrayList<Boolean> arr = new ArrayList<Boolean>();
		arr.add(Check);
		
		return Response.ok(arr ,MediaType.APPLICATION_JSON).build();
	}
	
	
	
	@GET
	@Path("comprobaNom/{nom}")
	public Response comprobaNom(@PathParam("nom") String nom) {
		return Response.ok(service.comprobaNomServ(nom), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("comprobaPermisos/{nombre}")
	public Response comprobaPermisos(@PathParam("nombre") String nombre) {
		return Response.ok(service.comrpobaPermisosServ(nombre), MediaType.APPLICATION_JSON).build();  //comproba els permisos del usuari
	}
	
	@PUT
	@Path("donarPermisos/{nom}")

	public Response donaPermisos(@PathParam("nom") String nom) {                           //otorga permisos                  
		
		service.donaPermisosServ(nom);
		Missatge mis = new Missatge("Permisos otorgats");
		
		return Response.ok(mis,MediaType.APPLICATION_JSON).build();
	}
	
	
	@PUT
	@Path("treurePermisos/{nom}")

	public Response treurePermisosServ(@PathParam("nom") String nom) {                           //treure permisos                  
		
		service.treurePermisosServ(nom);
		Missatge mis = new Missatge("Permisos retirats");
		
		return Response.ok(mis,MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	@POST
	@Path("/registra")
	public Response putUser(Usuari us) {                                        
		service.setUsuariServ(us);  //tmb torna boolean
		Usuari usu = service.getUserByNomServ(us.getNom());
		
		return Response.ok(usu ,MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	@DELETE
	@Path("delete/{nom}")
	public Response deleteUsuari(@PathParam("nom") String nom) {
		
		service.deleteUsuariServ(nom);
		Missatge mis = new Missatge("Esborrat correctement");
		
		
		return Response.ok(mis, MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	
}