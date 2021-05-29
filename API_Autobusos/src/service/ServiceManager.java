package service;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	public Ruta setRutaServ(Ruta ruta) {
		 dao.setRutas(ruta);
		 
		 //logica de comprobacion xd
		 
		 return ruta;
	}
	
	
	public String actualitzaRutaServ(Ruta ru,int id) {
		 
		dao.actualitzaRuta(ru,id);
		return "Ruta Actualitzada";
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
		
		public Linia setLiniaServ(Linia linia) {
			 dao.setLinia(linia);
			 return linia;  //devuelve el objeto para que retorne un json al frontend 
		}
		
		public String actualitzaLiniaServ(Linia li, int id_linia) {
			 dao.actualitzaLinia(li,id_linia);
			 
			 //logica de comprobacion xd
			 
			 return "Linia actualitzada";
		}
		
		public void deleteLiniaServ(int id) {
			dao.deleteLinia(id);
		}
	
	
		
		
	
	
	// ---------------USUARIS----------------------
	
	
	public ArrayList<Usuari> getUsuarisServ() {
		return dao.getUsuaris();
	}
	
	public ArrayList<Usuari> getUsuariPerIdServ(int id) {
		return dao.getUsuariPerId(id);
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
		 
		 dao.setUsuariTokenBD(us);  //registro a la taula de tokens el usuari per poder actualitzarlo cada cop que li cambi el token
		 return dao.setUsuari(us);
	}
	
	
	public Boolean comprobaNomServ(String nom) {
		return dao.comprobaNomRepetit(nom);
	}
	
	public int comrpobaPermisosServ(String nom) {
		return dao.comrpobaPermisos(nom);
	}
	
	public void donaPermisosServ(String nom) {
		 dao.donaPermisos(nom);
	}
	
	public void treurePermisosServ(String nom) {
		 dao.treurePermisos(nom);
	}
	
	
	public void actualitzaToken(String to, Usuari us) {
		 dao.actualitzaToken(to, us);
	}
	
	public void deleteUsuariServ(String nom) {
		dao.deleteUsuari(nom);
	}
	
	
	public Usuari getUserByNomServ(String nom) {
		return dao.getUserByNom(nom);
	}
	
	//---------------RESENYAS----------------------
	
	public ArrayList<Resenya> getResenyasServ() {
		return dao.getResenyas();
	}
	
	public Resenya GetResenyasByIdServ(int id) {
		return dao.GetResenyasById(id);
	}
	
	
	public ArrayList<Resenya> GetResenyasByNomServ(String nom) {
		return dao.getResenyasByNom(nom);
	}
	
	public Resenya insertResenyaServ(Resenya res) {
		dao.setResenya(res);
		 return res;
	}
	
	
	public void actualitzaResenyaServ(Resenya res,  int id) {
		 dao.actualitzaResenya(res, id);
	}
	
	public void deleteResenyaServ(int id) {
		dao.deleteResenya(id);
	}
	
	//---------------PARADAS----------------------
	
	public ArrayList<Parada> getParadasServ() {
		return dao.getParadas();
	}
	
	public Parada GetParadasByIdServ(int id) {
		return dao.GetParadasById(id);
	}
	
	public Parada getParadasByNomServ(String nom) {
		return dao.getParadaByNom(nom);
	}
	
	public Parada insertaParadaServ(Parada pa) {
		dao.insertaParada(pa);
		 return pa;
	}   
	
	public void deleteParadaServ(int id) {
		dao.deleteParada(id);
	}
	
	public void actualitzaParadaServ(Parada pa,  int id) {
		 dao.actualitzaParada(pa, id);
	}
	
	
	//---------------ASIGNACIONS----------------------
	
	public ArrayList<Asignacion> getAsignacionsServ() {
		return dao.getAsignacions();
	}
	
	public Asignacion getAsignacioByIdServ(int id) {
		return dao.getAsignacioById(id);
	}
	
	public ArrayList<Asignacion> getAsignacionsByUserId(int id) {
		return dao.getAsignacionsByUserId(id);
	}
	
	
	public ArrayList<Asignacion> getAsignacionsByDiaServ(String dia) {
		return dao.getAsignacionsByDia(dia);
	}
	
	public Asignacion insertaAsignacioServ(Asignacion as) {
		dao.insertaAsignacio(as);
		 return as;
	}
	
	public ArrayList<Asignacion> getAsignacionsByTipusServ(String tipus) {
		return dao.getAsignacionsByTipus(tipus);
	}
	
	public ArrayList<Asignacion> getAsignacionsDiaUserServ(String dia, int id) {
		return dao.getAsignacionsDiaUser(dia, id);
	}
	
	public void actualitzaAsignacioServ(Asignacion as,  int id) {
		 dao.actualitzaAsignacio(as, id);
	}
	
	public void deleteAsignacioServ(int id) {
		dao.deletAsignacio(id);
	}
	
	//---------------COMENTTARIS----------------------
	
		public ArrayList<Comentari> getTotsComentarisServ() {
			return dao.getTotsComentaris();
		}
		
		public Comentari getComentariByIdServ(int id) {
			return dao.getComentariId(id);
		}
		
		public ArrayList<Comentari> getComentariByUserServ(int user) {
			return dao.getComentariByUser(user);
		}
		
		public void updateComentariServ(Comentari co, int id) {
			dao.updateComentari(co, id);
		}

		
		public Comentari putComentariServ(Comentari co) {
			dao.putComentari(co);
			return co;
		}
		
		public void deleteComentariServ(int id) {
			dao.deleteComentari(id);
		}
		
		//---------------PARADALINIA----------------------
		
		public ArrayList<Paradalinia> getParadasLiniaServ(int id) {
			return dao.getParadasLinia(id);
		}
		
		public ArrayList<Paradalinia> getLiniasParadaServ(int id) {
			return dao.getLiniasParada(id);
		}
		
		public String insertaParadaLiniaServ(Paradalinia pali) {
			if(dao.insertaParadaLinia(pali)) {
				return "ok";
			}else {
				return "Error: parada ya incluida en la linia";
			}
		}
		
		public void deleteParadaLiniaServ(int id_parada, int id_linia, int ordre) {
			dao.deleteParadaLinia(id_parada, id_linia, ordre );
		}
		
		
		public ArrayList<ParadaCompleta> getParadasCompleteServ(int id) {
			return dao.getParadasComplete(id);
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