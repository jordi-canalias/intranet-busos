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
	 * GET totsUsuaris ==> {"/"}
	GET usuariById ==> {"/id"}
	GET usuarisByFuncio ==> {"/funcio"}
	GET getUsuariosOrdenEntrada ==> {"/"}
	PUT checkUsuari ==> {"/login"}
	PUT setUsuario ==> {"/"}
	POST updateUsuario ==> {"/id"}
	DELETE borraUsuario ==> {"/id"}
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
	public Response putUser(Usuari us) {                                        //comproba el token del usuari
		
		actualitzaUsuariServ(us,nom);
		
		return Response.ok(creacio ,MediaType.APPLICATION_JSON).build();
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
	
	
	
	
	
	
	
	
	
	/*
	@GET
	@Path("{id}")
	public Response getUsuariById(@PathParam("id") int id) {
		return Response.ok(service.getUsuariByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("{user}")
	public Response getRutaByUsuari(@PathParam("user") int user) {
		return Response.ok(service.getRutaByUserServ(user), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("{date}")
	public Response getRutaByDia(@PathParam("date") String date) {
		return Response.ok(service.getRutaByDateServ(date), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("{bus}")
	public Response getRutaByBus(@PathParam("bus") String bus) {
		return Response.ok(service.getRutaByBusServ(bus), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("{client}")
	public Response getRutaByClient(@PathParam("client") String client) {
		return Response.ok(service.getRutaByClienteServ(client), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("{lloc}")
	public Response getRutaByLloc(@PathParam("client") String client) {
		return Response.ok(service.getRutaByClienteServ(client), MediaType.APPLICATION_JSON).build();
	}
	*/
	
}