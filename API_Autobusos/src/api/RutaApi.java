package api;

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

import model.Missatge;
import model.Resenya;
import model.Ruta;
import service.ServiceManager;

@Path("/rutas")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class RutaApi {
	
	private ServiceManager service;
	
	public RutaApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
	 * GET rutaById ==> {"/id"}
		GET rutasByUsuari (chofer, guia o oficinista)  ==> {"/usuari"}
		GET rutasByDia  ==> {"/date"}
		GET rutasByBus ==> {"/bus"}
		GET rutasByClient ==> {"/client"}
		GET rutasByLLoc  ==> {"/lloc"}
		PUT insertaRuta ==> {"/"}
		POST actualitzaRuta ==> {"/"}
		DELETE borraRuta ==> {"/"}
	 */
	
	
	@GET
	@Path("/")
	public Response getRutas() {
		return Response.ok(service.getRutasServ(), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("{id}")
	public Response getRutaById(@PathParam("id") int id) {
		return Response.ok(service.getRutaByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("guia/{guia}")
	public Response getRutaByUsuari(@PathParam("guia") String guia) {
		return Response.ok(service.getRutasByGuiaServ(guia), MediaType.APPLICATION_JSON).build();
	}

	
	@GET
	@Path("client/{client}")
	public Response getRutasByClient(@PathParam("client") String client) {
		return Response.ok(service.getRutasByClientServ(client), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("lloc/{lloc}")
	public Response getRutaByDia(@PathParam("lloc") String lloc) {
		return Response.ok(service.getRutasByLlocServ(lloc), MediaType.APPLICATION_JSON).build();
	}
	
	
	@POST
	@Path("/")
	public Response putNewRuta(Ruta ruta) {
		return Response.ok(service.setRutaServ(ruta), MediaType.APPLICATION_JSON).build();
	}
	
	
	@PUT
	@Path("/actualitza/{id}")
	public Response actualitzaRuta(Ruta ru,@PathParam("id") int id) {                                      
		
		service.actualitzaRutaServ(ru,id);
		
		Ruta ruta = service.getRutaByIdServ(id);
		
		return Response.ok(ruta,MediaType.APPLICATION_JSON).build();
	}
	
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteRuta(@PathParam("id") int id) {
		service.deleteRutaServ(id);
		Missatge mis = new Missatge("Ruta eliminada");
		return Response.ok(mis , MediaType.APPLICATION_JSON).build();
	}
	
	
	
	

}
