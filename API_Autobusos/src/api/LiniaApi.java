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


import model.*;
import service.ServiceManager;

@Path("/linias")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class LiniaApi {
	
	private ServiceManager service;
	
	public LiniaApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
			GET totesLinias ==> {"/"}
			GET liniaById ==> {"/id"}
			GET liniaByNom ==> {"/nom"}
			GET liniaByBus ==> {"/bus"}
			GET liniaByParada ==> {"/parada"}  
			PUT insertaLinia ==> {"/"}
			POST actualitzaLinia ==> {"/"}
			DELETE deleteLinia ==> {"/"}


	
	 */
	
	
	@GET
	@Path("/")
	public Response getLinias() {
		return Response.ok(service.getLiniasServ(), MediaType.APPLICATION_JSON).build();        //NO FUNCIONA, PERO TAMPOC DONA ERROR 
	}
	
	
	@GET
	@Path("{id}")
	public Response getLiniaById(@PathParam("id") int id) {
		return Response.ok(service.getLiniaByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("nom/{nom}")
	public Response getLiniaByNom(@PathParam("nom") String nom) {
		return Response.ok(service.getLiniaByNomServ(nom), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("bus/{bus}")
	public Response getLiniaByBus(@PathParam("bus") String bus) {
		return Response.ok(service.getLiniaByBusServ(bus), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/")
	public Response putNewLinia(Linia linia) {
		return Response.ok(service.setLiniaServ(linia), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("/actualitza/{id}")
	public Response actualitzaLinia(Linia li,@PathParam("id") int id) {                                      
		service.actualitzaLiniaServ(li,id);
		Linia lin = service.getLiniaByIdServ(id);
		return Response.ok(lin,MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteLinia(@PathParam("id") int id) {
		service.deleteLiniaServ(id);
		Missatge mis = new Missatge("Linia esborrada correctament");
		return Response.ok(mis , MediaType.APPLICATION_JSON).build();
	}

}
