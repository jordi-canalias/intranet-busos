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

@Path("/paradalinia")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")

public class ParadaLiniaApi {
	
	private ServiceManager service;
	       
	public ParadaLiniaApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
	 *      GET paradasLinia ==> "/id_linia/{id_linia}"
			GET liniasParada ==> "/id_parada/{id_parada}"
			PUT insertaParadaLinia ==> "/inserta"
			PUT editaParadaLinia==> "/inserta"
			DELETE paradaLinia ==> "/delete/{id_parada}"
	 */

	@GET
	@Path("/id_linia/{id}")
	public Response paradasLinia(@PathParam("id") int id) {
		return Response.ok(service.getParadasLiniaServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/id_parada/{id}")
	public Response liniasParada(@PathParam("id") int id) {
		return Response.ok(service.getLiniasParadaServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("/inserta")
	public Response insertaParada(Paradalinia pali) {	
		Missatge mis = new Missatge(service.insertaParadaLiniaServ(pali));
		return Response.ok(mis,MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/complete/{id}")
	public Response liniasParadaComplete(@PathParam("id") int id) {
		return Response.ok(service.getParadasCompleteServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	
	@DELETE
	@Path("/delete/{id_linia}/{id_parada}/{ordre}")
	public Response delete(@PathParam("id_linia") int id_linia, @PathParam("id_linia") int id_parada, @PathParam("ordre") int ordre) {
		service.deleteParadaLiniaServ(id_parada, id_linia, ordre);
		Missatge mis = new Missatge("Esborrada parada de la linia");
		return Response.ok(mis, MediaType.APPLICATION_JSON).build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//----------final above------
	/*
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
	*/
	
	

	
	
}