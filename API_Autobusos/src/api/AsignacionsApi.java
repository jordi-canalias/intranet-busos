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

@Path("/asignacions")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
		     
public class AsignacionsApi {
	
	private ServiceManager service;
	
	public AsignacionsApi() {
		service=new ServiceManager();
	}
	
	  
	//test-----------
	
	/*
	 * 
		GET totesAsignacions ==> {"/"} check
		GET asignacioById ==> {"/id"}  check
		GET asignacoionsByUserId ==> {"/user_id"}   chek
		GET getAsignacionsByDia ==> {"/dia"} check
		GET getAsignacionsByTipus ==> {"/tipus"} check
		GET getAsignacionsDiaUser==> {"/diaUser"} check
		PUT putAsignacio ==> {"/id"} check
		PUT updateAsignacio ==> {"/id"} check
		DELETE borraAsignacio ==> {"/id"} check

	 */
	
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
	@Path("/user/{nom}")
	public Response getAsignacionsByUserId(@PathParam("nom") String nom) {
		return Response.ok(service.getAsignacionsByUserId(nom), MediaType.APPLICATION_JSON).build();
	}
	
	@GET
	@Path("/dia/{dia}")
	public Response getAsignacionsByDay(@PathParam("dia") String dia) {
		return Response.ok(service.getAsignacionsByDiaServ(dia), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/inserta")
	public Response insertaAsignacio(Asignacion as) {	
		Asignacion asa = service.insertaAsignacioServ(as);
		return Response.ok(asa,MediaType.APPLICATION_JSON).build();
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
		Asignacion asi = service.getAsignacioByIdServ(id);
		return Response.ok(asi,MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteAsignacio(@PathParam("id") int id) {
		service.deleteAsignacioServ(id);
		Missatge mis = new Missatge("Esborrat correctement");
		return Response.ok(mis, MediaType.APPLICATION_JSON).build();
	}
	
	
	//----------final above------
	
	
	
}