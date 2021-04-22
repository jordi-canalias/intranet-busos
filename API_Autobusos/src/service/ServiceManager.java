package service;

import java.util.ArrayList;
import java.util.Random;

import dao.DatabaseDao;
import model.*;



public class ServiceManager {
	private DatabaseDao dao;

	public ServiceManager() {
		this.dao = new DatabaseDao();
	}
	
	// ---------------RUTAS----------------------
	
	
	public ArrayList<Ruta> getRutasServ() {
		return dao.getRutas();
	}
	
	public Ruta getRutaByIdServ(int id) {
		return dao.getRutaById(id);
	}
	
	
	public ArrayList<Ruta> getRutasByGuiaServ(String guia) {
		return dao.getRutasByGuia(guia);
	}
	
	public ArrayList<Ruta> getRutasByClientServ(String client) {
		return dao.getRutasByClient(client);
	}
	
	public ArrayList<Ruta> getRutasByLlocServ(String lloc) {
		return dao.getRutasByLloc(lloc);
	}
	
	public String setRutaServ(Ruta ruta) {
		 dao.setRutas(ruta);
		 
		 //logica de comprobacion xd
		 
		 return "Ruta insertada";
	}
	
	public String deleteRutaServ(int id) {
		 dao.deleteRuta(id);
		 
		 //logica de comprobacion xd
		 
		 return "Ruta eliminada";
	}
	
	// ---------------LINIAS----------------------
	
	
		public ArrayList<Linia> getLiniasServ() {
			return dao.getLinias();
		}
	
		
		public Linia getLiniaByIdServ(int id) {
			return dao.getLiniaById(id);
		}
		
		public Linia getLiniaByNomServ(String nom) {
			return dao.getLiniaByNom(nom);
		}
		
		public Linia getLiniaByBusServ(String bus) {
			return dao.getLiniaByBus(bus);
		}
		
		public String setLiniaServ(Linia linia) {
			 dao.setLinia(linia);
			 
			 //logica de comprobacion xd
			 
			 return "Linia insertada";
		}
		
	
	
		
		
	
	
	// ---------------USUARIS----------------------
	
	
	public ArrayList<Usuari> getUsuarisServ() {
		return dao.getUsuaris();
	}
	
	public ArrayList<Usuari> getUsuarisPerFuncioServ(String funcio) {
		return dao.getUsuarisPerFuncio(funcio);
	}
	
	public void actualitzaUsuariServ(Usuari newUs, String nom) {
		 dao.actualitzaUsuari(newUs, nom);
	}
	
	public Boolean checkUsuariServ(Usuari us) {
		return dao.checkUsuari(us);
	}
	
	public Boolean checkToken(Token to) {
		return dao.checkToken(to);
	}
	
	public Boolean setUsuariServ(Usuari us) {
		 
		 return dao.setUsuari(us);
	}
	
	public void actualitzaToken(String to, Usuari us) {
		 dao.actualitzaToken(to, us);
	}
	
	
	
	public String tokenGen() {
		int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 30;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
	
	
}