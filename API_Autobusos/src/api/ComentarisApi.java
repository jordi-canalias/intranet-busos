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

@Path("/comentaris")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
		     
public class ComentarisApi {
	
	private ServiceManager service;
	
	public ComentarisApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
	 * 
		GET totsComentaris==> {"/"} check
		GET comentarisByIdResenya ==> {"/id"} check
		GET comentarisByIdUsuari ==> {"/user"} 
		PUT editaComentari ==> {"/update"} 
		DELETE borraComentari ==> {"/delete"} 

	 */
	
	
	
	@GET
	@Path("/")
	public Response totsComentaris() {	
		ArrayList<Comentari> co = service.getTotsComentarisServ();
		return Response.ok(co, MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/id/{id}")
	public Response getComentariById(@PathParam("id") int id) {
		return Response.ok(service.getComentariByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/user/{user}")
	public Response getComentariByUser(@PathParam("user") int user) {
		return Response.ok(service.getComentariByUserServ(user), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/inserta")
	public Response putComentari(Comentari co) {	
		Comentari com = service.putComentariServ(co);
		return Response.ok(com,MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("/update/{id}")
	public Response updateComentari(Comentari co ,@PathParam("id") int id) {	
		service.updateComentariServ(co, id);
		Comentari com = service.getComentariByIdServ(id);
		return Response.ok(com,MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response d(@PathParam("id") int id) {
		service.deleteComentariServ(id);
		Missatge mis = new Missatge("Esborrat correctement");
		return Response.ok(mis, MediaType.APPLICATION_JSON).build();
	}
	
	
	
	/*
	@GET
	@Path("/user/{id}")
	public Response getComentariByUser(@PathParam("id") int id) {
		return Response.ok(service.getComentariByUserServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("/update/{id}")
	public Response updateComentari(Comentari co ,@PathParam("id") int id) {	
		service.updateComentariServ(co, id);
		return Response.ok("Asignacio Actualitzada",MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteComentari(@PathParam("id") int id) {
		service.deleteComentariServ(id);
		return Response.ok("Esborrat correctament", MediaType.APPLICATION_JSON).build();
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	//----------final above------
	
	
	
	
	
	/*
	@GET
	@Path("/")
	public Response totesAsignacions() {	
		ArrayList<Asignacion> as = service.getAsignacionsServ();
		return Response.ok(as, MediaType.APPLICATION_JSON).build();
	}
	
	
	@GET
	@Path("/id/{id}")
	public Response getAsignacioId(@PathParam("id") int id) {
		return Response.ok(service.getAsignacioByIdServ(id), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/user/{id}")
	public Response getAsignacionsByUserId(@PathParam("id") int id) {
		return Response.ok(service.getAsignacionsByUserId(id), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/dia/{dia}")
	public Response getAsignacionsByDay(@PathParam("dia") String dia) {
		return Response.ok(service.getAsignacionsByDiaServ(dia), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("/inserta")
	public Response insertaAsignacio(Asignacion as) {	
		service.insertaAsignacioServ(as);
		return Response.ok("Asignacio Insertada",MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/tipus/{tipus}")
	public Response getAsignacionsByFuncio(@PathParam("tipus") String tipus) {
		return Response.ok(service.getAsignacionsByTipusServ(tipus), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/diauser/{dia}/{id}")
	public Response getAsignacionsDiaUser(@PathParam("dia") String dia, @PathParam("id") int id) {
		return Response.ok(service.getAsignacionsDiaUserServ(dia, id), MediaType.APPLICATION_JSON).build();
	}
	
	@PUT
	@Path("/update/{id}")
	public Response insertaAsignacio(Asignacion as ,@PathParam("id") int id) {	
		service.actualitzaAsignacioServ(as, id);
		return Response.ok("Asignacio Actualitzada",MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteAsignacio(@PathParam("id") int id) {
		service.deleteAsignacioServ(id);
		return Response.ok("Esborrat correctament", MediaType.APPLICATION_JSON).build();
	}
	
	

	
	*/
	
}