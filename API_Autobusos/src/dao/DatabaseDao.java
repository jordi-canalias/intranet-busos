package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import config.ConstantsApi;
import model.*;


public class DatabaseDao {
	
	
	
//**********************************************************************************************
//***************************************       RUTAS       ************************************
//**********************************************************************************************
	
	
	public ArrayList<Ruta> getRutas() {

		ArrayList<Ruta> rutas = new ArrayList<Ruta>();
		//ArrayList<Parada> paradas = new ArrayList<Parada>();

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.rutas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Ruta ru = new Ruta(rs.getInt("id_ruta"),rs.getString("nom"),rs.getString("caracter"),rs.getString("client"),
						rs.getString("recollida"),rs.getString("destinacio"),rs.getString("informacion"),
						rs.getString("guia_asignat"));
				
				//com poso el json dels ous a una arraylist?  (parse???)

				rutas.add(ru);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return rutas;

	}
	
	
	public Ruta getRutaById(int id) {

		Connection con;

		 int id_ruta = 0;
		 String nom = null;
		 String caracter = null;
		 String client = null;
		 String recollida = null;
		 String destinacio = null;
		 String informacion = null;
		 String guia_asignat = null;


		try {
			con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.rutas WHERE id_ruta = '" + id + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				id_ruta = rs.getInt("id_ruta");
				nom = rs.getString("nom");
				caracter = rs.getString("caracter");
				client = rs.getString("client");
				recollida = rs.getString("recollida");
				destinacio = rs.getString("destinacio");
				informacion = rs.getString("informacion");
				guia_asignat = rs.getString("guia_asignat");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Ruta ru = new Ruta(id_ruta, nom, caracter, client, recollida, destinacio, informacion, guia_asignat);
		
		System.out.print(ru);
		return ru;
	}
	
	
	
	
	public ArrayList<Ruta> getRutasByGuia(String guia ) {

		ArrayList<Ruta> rutas = new ArrayList<Ruta>();
		//ArrayList<Parada> paradas = new ArrayList<Parada>();

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.rutas WHERE guia_asignat = '" + guia + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Ruta ru = new Ruta(rs.getInt("id_ruta"),rs.getString("nom"),rs.getString("caracter"),rs.getString("client"),
						rs.getString("recollida"),rs.getString("destinacio"),rs.getString("informacion"),
						rs.getString("guia_asignat"));
				

				rutas.add(ru);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return rutas;

	}
	
	public ArrayList<Ruta> getRutasByClient(String client ) {

		ArrayList<Ruta> rutas = new ArrayList<Ruta>();

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.rutas WHERE client = '" + client + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Ruta ru = new Ruta(rs.getInt("id_ruta"),rs.getString("nom"),rs.getString("caracter"),rs.getString("client"),
						rs.getString("recollida"),rs.getString("destinacio"),rs.getString("informacion"),
						rs.getString("guia_asignat"));

				rutas.add(ru);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return rutas;

	}
	
	
	
	
	
	public ArrayList<Ruta> getRutasByLloc(String lloc ) {

		ArrayList<Ruta> rutas = new ArrayList<Ruta>();

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.rutas WHERE destinacio = '" + lloc + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Ruta ru = new Ruta(rs.getInt("id_ruta"),rs.getString("nom"),rs.getString("caracter"),rs.getString("client"),
						rs.getString("recollida"),rs.getString("destinacio"),rs.getString("informacion"),
						rs.getString("guia_asignat"));
				

				rutas.add(ru);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return rutas;

	}
	
	
	
	public void setRutas(Ruta Ruta) { // insertar rutas

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);


			int id_ruta = 0;
			String nom = Ruta.getNom();
			String caracter = Ruta.getCaracter(); 
			String client = Ruta.getClient();
			String recollida = Ruta.getRecollida();
			String destinacio = Ruta.getDestinacio();
			String informacion = Ruta.getInformacion();
			String guia_asignat = Ruta.getGuia_asignat();
			
			
			PreparedStatement query = con.prepareStatement(
					" INSERT INTO autobusos.rutas (id_ruta, nom, caracter, client, recollida, destinacio, informacion, guia_asignat) VALUES (' "
							+ id_ruta + " ','" + nom + "','" + caracter + "','" + client + "','" + recollida
							+ "','"+ destinacio +"', '"+informacion+"','"+guia_asignat+"') ");

			
			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	
	

	public void actualitzaRuta(Ruta ru,int id_ruta) {

		String nom = ru.getNom();
		String caracter = ru.getCaracter();
		String client = ru.getClient();
		String recollida = ru.getRecollida();
		String destinacio = ru.getDestinacio();
		String informacion = ru.getInformacion();
		String guia_asignat = ru.getGuia_asignat();
		
		
		//UPDATE autobusos.rutas SET nom='"+to+"', caracter='"+data+"', client='"+data+"', recollida='"+data+"', destinacio='"+data+"', informacion='"+data+"', guia_asignat='"+data+"' WHERE id_ruta='"+id_ruta+"';
		
		String query = "UPDATE autobusos.rutas SET nom='"+nom+"', caracter='"+caracter+"', client='"+client+"', recollida='"+recollida+"', destinacio='"+destinacio+"', informacion='"+informacion+"', guia_asignat='"+guia_asignat+"' WHERE id_ruta='"+id_ruta+"';";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	
	
	
	public void deleteRuta(int id) {
		
		String query = "DELETE FROM autobusos.rutas WHERE id_ruta='"+id+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	
	
	
	//***********************************************************************************************
	//***************************************       LINIAS       ************************************
	//***********************************************************************************************
	
	
	public ArrayList<Linia> getLinias() {

		ArrayList<Linia> linias = new ArrayList<Linia>();

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.linias;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Linia li = new Linia(rs.getInt("id_linia"),rs.getString("nom"),rs.getString("informacion"),rs.getString("bus_asignat"),
						rs.getString("hora_inici"),rs.getString("hora_finalitzacio"));


				linias.add(li);
				
				System.out.print(li);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return linias;

	}
	
	
	public Linia getLiniaById(int id) {

		Connection con;

		 int id_linia = 0;
		 String nom = null;
		 String informacion = null;
		 String bus_asignat = null;
		 String hora_inici = null;
		 String hora_finalitzacio = null;

		 

		try {
			con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.linias WHERE id_linia = '" + id + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				id_linia = rs.getInt("id_linia");
				nom = rs.getString("nom");
				informacion = rs.getString("informacion");
				bus_asignat = rs.getString("bus_asignat");
				hora_inici = rs.getString("hora_inici");
				hora_finalitzacio = rs.getString("hora_finalitzacio");
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Linia li = new Linia(id_linia, nom, informacion, bus_asignat, hora_inici, hora_finalitzacio);
		
		return li;
	}
	
	
	public Linia getLiniaByNom(String nomb) {

		Connection con;

		 int id_linia = 0;
		 String nom = null;
		 String informacion = null;
		 String bus_asignat = null;
		 String hora_inici = null;
		 String hora_finalitzacio = null;

		 

		try {
			con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.linias WHERE nom = '" + nomb + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				id_linia = rs.getInt("id_linia");
				nom = rs.getString("nom");
				informacion = rs.getString("informacion");
				bus_asignat = rs.getString("bus_asignat");
				hora_inici = rs.getString("hora_inici");
				hora_finalitzacio = rs.getString("hora_finalitzacio");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Linia li = new Linia(id_linia, nom, informacion, bus_asignat, hora_inici, hora_finalitzacio);
		
		return li;
	}

	
	
	
	
	public Linia  getLiniaByBus(String bus){

		Connection con;

		 int id_linia = 0;
		 String nom = null;
		 String informacion = null;
		 String bus_asignat = null;
		 String hora_inici = null;
		 String hora_finalitzacio = null;

		 

		try {
			con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.linias WHERE bus_asignat = '" + bus + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				id_linia = rs.getInt("id_linia");
				nom = rs.getString("nom");
				informacion = rs.getString("informacion");
				bus_asignat = rs.getString("bus_asignat");
				hora_inici = rs.getString("hora_inici");
				hora_finalitzacio = rs.getString("hora_finalitzacio");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Linia li = new Linia(id_linia, nom, informacion, bus_asignat, hora_inici, hora_finalitzacio);
		
		return li;
	}
	
	
	
	 //aqui
	public void setLinia(Linia linia) { // insertar rutas

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			int id_linia = 0;
			String nom = linia.getNom();
			String informacion = linia.getInformacion(); 
			String bus_asignat = linia.getBus_asignat();
			String hora_inici = linia.getHora_inici();
			String hora_finalitzacio = linia.getHora_finalitzacio();
			
			
			PreparedStatement query = con.prepareStatement(
					" INSERT INTO autobusos.linias (id_linia, nom, informacion, bus_asignat, hora_inici, hora_finalitzacio) "
					+ "VALUES ("+id_linia+",'"+nom+"','"+informacion+"','"+bus_asignat+"','"+hora_inici+"','"+hora_finalitzacio+"');");

			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	
	public void actualitzaLinia(Linia li,int id_linia) {

		String nom = li.getNom();
		String informacion = li.getInformacion();
		String bus_asignat = li.getBus_asignat();
		String hora_inici = li.getHora_inici();
		String hora_finalitzacio = li.getHora_finalitzacio();
		
		
		//UPDATE autobusos.linias SET nom='"+nom+"', informacion='"+informacion+"', bus_asignat='"+bus_asignat+"', hora_inci='"+hora_inci+"', hora_finalitzacio='"+hora_finalitzacio+"' WHERE id_linia='"+id_linia+"';
		
		String query = "UPDATE autobusos.linias SET nom='"+nom+"', informacion='"+informacion+"', bus_asignat='"+bus_asignat+"', hora_inici='"+hora_inici+"', hora_finalitzacio='"+hora_finalitzacio+"' WHERE id_linia='"+id_linia+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	public void deleteLinia(int id) {		
		
		String query = "DELETE FROM autobusos.linias WHERE id_linia = '"+id+"'";
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
	}
	
	
	
	
	//**********************************************************************************************
	//***************************************       USERS       ************************************
	//**********************************************************************************************
	
	public ArrayList<Usuari> getUsuaris() {

		ArrayList<Usuari> users = new ArrayList<Usuari>();


		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuari us = new Usuari(rs.getInt("id_usuari"),rs.getString("nom"),rs.getString("cognoms"),
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getString("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

				users.add(us);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return users;
	}
	
	
	
	
	
	public ArrayList<Usuari> getUsuariPerId(int id) {

		ArrayList<Usuari> users = new ArrayList<Usuari>();


		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris WHERE id_usuari='"+id+"'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuari us = new Usuari(rs.getInt("id_usuari"),rs.getString("nom"),rs.getString("cognoms"),
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getString("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

				users.add(us);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return users;
	}
	
	
	
	
	public Usuari getUserByNom(String nom) {
		
		int id_usuari = 0;
		String nomm = "";
		String cognoms = "";
		String funcio = "";
		String fecha_entrada = "";
		String telefon = "";
		String correuElectronic = "";
		String permisos = "";
		String contrasenya = "";

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris WHERE nom='"+nom+"'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				id_usuari = rs.getInt("id_usuari");
				nomm = rs.getString("nom");
				cognoms = rs.getString("cognoms");
				funcio = rs.getString("funcio");
				fecha_entrada = rs.getString("fecha_entrada");
				telefon = rs.getString("telefon");
				correuElectronic = rs.getString("correuElectronic");
				permisos = rs.getString("permisos");
				contrasenya = rs.getString("contrasenya");

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		
		Usuari us = new Usuari(id_usuari, nomm, cognoms, funcio, fecha_entrada, telefon, correuElectronic, permisos, contrasenya);
		
		return us;
	}
	
	
	
	
	
	
	public ArrayList<Usuari> getUsuarisPerFuncio(String funcio) {

		ArrayList<Usuari> users = new ArrayList<Usuari>();


		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris WHERE funcio='"+funcio+"'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuari us = new Usuari(rs.getInt("id_usuari"),rs.getString("nom"),rs.getString("cognoms"),
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getString("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

				users.add(us);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return users;
	}
	





	public Boolean checkUsuari(Usuari us) {
		
		String nom = us.getNom();
		String pass = us.getContrasenya();
		
		ArrayList<Usuari> users = new ArrayList<Usuari>();
		
		
		//SELECT * FROM autobusos.usuaris WHERE id_usuari='-1' and contrasenya='1234'
		
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris WHERE nom='"+nom+"' and contrasenya='"+pass+"'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuari user = new Usuari(rs.getInt("id_usuari"),rs.getString("nom"),rs.getString("cognoms"),
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getString("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

				users.add(user);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		if(users.size() == 1) {
			return true;  //login correcte
		}
		return false; //login incorrecte
	}
	
	
	
	
	
	public void actualitzaToken(String to, Usuari us) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		
		String nom = us.getNom();
		
		//UPDATE autobusos.tokens SET token='"+to+"', hora_inici='"+data+"' WHERE id_usuari='"+id_usuari+"';

		String query = "UPDATE autobusos.tokens SET token='"+to+"', hora_inici='"+dtf.format(now)+"' WHERE usuari='"+nom+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	
	
	
	
	
	
	public Boolean checkToken(Token to) {
		
		Boolean resp = false;
		String token = to.getToken();
		String nom = to.getUsuari();
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		
		//SELECT * FROM autobusos.usuaris WHERE id_usuari='-1' and contrasenya='1234'
		
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.tokens WHERE usuari='"+nom+"' and token='"+token+"'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Token tok = new Token(rs.getInt("id_usuari"),rs.getString("usuari"),rs.getString("token"),
						rs.getString("hora_inici"));
				

				tokens.add(tok);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		
		
		if(tokens.size() == 1) {
			return true;  //token correcte
		}
		return false; //token incorrecte
	}
	
	
	
	public Boolean comprobaNomRepetit(String nom) {

		ArrayList<Usuari> users = new ArrayList<Usuari>();


		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris WHERE nom='"+nom+"'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuari us = new Usuari(rs.getInt("id_usuari"),rs.getString("nom"),rs.getString("cognoms"),
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getString("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

				users.add(us);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		if(users.size() < 1) {
		return false;
		}
		return true;
	}
	
	
	
	public Boolean setUsuari(Usuari us) { // insertar usuari
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		//dtf.format(now);
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);


			int id_usuario = 0;
			String nom = us.getNom();
			String cognoms = us.getCognoms();
			String funcio = us.getFuncio();
			String fecha_entrada = dtf.format(now);
			String telefon = us.getTelefon();
			String correuElectronic  = us.getCorreu_electronic();
			String permisos = "0";
			String contrasenya = us.getContrasenya();
			
			//el nom repetit es comproba a part
			
			/*    
			if(comprobaNomRepetit(nom)) {
				return false;
				
			}
			*/
			
			PreparedStatement query = con.prepareStatement(
					" INSERT INTO autobusos.usuaris (id_usuari, nom, cognoms, funcio, fecha_entrada, telefon, correuElectronic, permisos, contrasenya) VALUES (' "
							+ id_usuario + " ','" + nom + "','"+ cognoms +"','" + funcio + "','" + fecha_entrada + "','" + telefon+ "','" + correuElectronic+ "','" + permisos+ "','" + contrasenya+ "') ");

			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
		}
		
		return true;
	}
	
	
	
	
	
	
	public Boolean setUsuariTokenBD(Usuari us) { // insertar usuari a la base de dades de token

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);


			int id_usuari = 0;
			String nom = us.getNom();
			String fecha_entrada = "";
			String token = "";

			
			PreparedStatement query = con.prepareStatement(
					" INSERT INTO autobusos.tokens (id_usuari, usuari, token, hora_inici) VALUES (' "
							+ id_usuari + " ','" + nom + "','"+ token +"','" + fecha_entrada + "') ");

			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
		}
		
		return true;
	}
	
	
	
	
	
	public void actualitzaUsuari(Usuari newUs, String nomUsuari) {

		

		String cognoms = newUs.getCognoms();
		String telefon = newUs.getTelefon();
		String correuElectronic  = newUs.getCorreu_electronic();
		String contrasenya = newUs.getContrasenya();
		
		
		String query = "UPDATE autobusos.usuaris  cognoms='"+cognoms+"', telefon='"+telefon+"', correuElectronic='"+correuElectronic+"', contrasenya='"+contrasenya+"' WHERE nom='"+nomUsuari+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	
	
	public void deleteUsuari(String nom) {		
		
		String query = "DELETE FROM autobusos.usuaris WHERE nom = '"+nom+"'";
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
	}
	
	
	
	public int comrpobaPermisos(String nom) {

		int permisos = 0;

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris WHERE nom='"+nom+"'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				permisos = rs.getInt("permisos");

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
			
			return permisos;
		}
	
	
	
	
		public void donaPermisos(String nomUsuari) {

		
		String query = "UPDATE autobusos.usuaris SET permisos='1' WHERE nom='"+nomUsuari+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
		
		
		
		
		public void treurePermisos(String nomUsuari) {

			
			String query = "UPDATE autobusos.usuaris SET permisos='0' WHERE nom='"+nomUsuari+"'";
			
			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);
				
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.execute();

				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
			}
			
			
		}
	
	
	//**********************************************************************************************
	//***************************************       RESENYA       ************************************
	//**********************************************************************************************
	
	
	
	
	
	public ArrayList<Resenya> getResenyas() {

		ArrayList<Resenya> res = new ArrayList<Resenya>();


		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.resenyas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Resenya rese = new Resenya(rs.getInt("id_resenya"),
										  rs.getString("nom"),
										  rs.getInt("id_usuari"),
										  rs.getString("fecha"),
										  rs.getString("informacion"),
										  rs.getString("links"),
										  rs.getString("hastags"));
				

				res.add(rese);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return res;
	}
	
	
	
	
	
	public Resenya GetResenyasById(int id) {

		Connection con;

		 int id_resenya = 0;
		 String nom = null;
		 int id_usuari = 0;
		 String fecha = null;
		 String informacion = null;
		 String links = null;
		 String hastags = null;


		try {
			con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.resenyas WHERE id_resenya = '" + id + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				id_resenya = rs.getInt("id_resenya");
				nom = rs.getString("nom");
				id_usuari = rs.getInt("id_usuari");
				fecha = rs.getString("fecha");
				informacion = rs.getString("informacion");
				links = rs.getString("links");
				hastags = rs.getString("hastags");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Resenya  re = new Resenya(id_resenya, nom, id_usuari, fecha, informacion, links, hastags);

		return re;
	}
	
	
	
	

	public ArrayList<Resenya> getResenyasByNom(String nom) {

		ArrayList<Resenya> res = new ArrayList<Resenya>();


		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.resenyas WHERE nom = '"+nom+"';");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Resenya rese = new Resenya(rs.getInt("id_resenya"),
										  rs.getString("nom"),
										  rs.getInt("id_usuari"),
										  rs.getString("fecha"),
										  rs.getString("informacion"),
										  rs.getString("links"),
										  rs.getString("hastags"));
				

				res.add(rese);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return res;
	}
	
	
	
	public void setResenya(Resenya res) { // insertar resenya

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		LocalDateTime now = LocalDateTime.now();  
		//dtf.format(now);
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);


			 int id_resenya = res.getId_resenya();
			 String nom = res.getNom();
			 int id_usuari = res.getId_usuari();
			 String fecha = dtf.format(now);
			 String informacion = res.getInformacion();
			 String links = res.getLinks();
			 String hastags = res.getHastags();
			
			PreparedStatement query = con.prepareStatement(
					" INSERT INTO autobusos.resenyas (id_resenya, nom, id_usuari, fecha, informacion, links, hastags) VALUES (' "
							+ id_resenya + " ','" + nom + "','"+ id_usuari +"','" + fecha + "','" + informacion + "','" + links
							+ "', '"+hastags+"') ");

			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	
	
	
	
	public void actualitzaResenya(Resenya res, int id) {   //actualitza resenya

		 String nom = res.getNom();
		 String informacion = res.getInformacion();
		 String links = res.getLinks();
		 String hastags = res.getHastags();

		String query = "UPDATE autobusos.resenyas SET nom='"+nom+"', informacion='"+informacion+"', links='"+links+"', hastags='"+hastags+"' WHERE id_resenya='"+id+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	
	
	
	
	public void deleteResenya(int id) {		
		
		String query = "DELETE FROM autobusos.resenyas WHERE id_resenya = '"+id+"' ";
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	
	
	
	
	
	//**********************************************************************************************
	//***************************************      PARADAS      ************************************
	//**********************************************************************************************
	
	
	public ArrayList<Parada> getParadas() {

		ArrayList<Parada> par = new ArrayList<Parada>();


		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.paradas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Parada para = new Parada(rs.getInt("id_parada"),
										  rs.getString("nom"),
										  rs.getString("ubicacio"),
										  rs.getString("informacion"));
				
				par.add(para);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return par;
	}
	
	
	
	
	
	
	public Parada GetParadasById(int id) {

		Connection con;

		 int id_parada = 0;
		 String nom = null;
		 String ubicacio = null;
		 String informacion = null;

		try {
			con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.paradas WHERE id_parada = '" + id + "'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				id_parada = rs.getInt("id_parada");
				nom = rs.getString("nom");
				ubicacio = rs.getString("ubicacio");
				informacion = rs.getString("informacion");


			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		Parada  pa = new Parada(id_parada, nom, ubicacio, informacion);

		return pa;
	}
	
	
	
	

	public Parada getParadaByNom(String nomb) {

		int id_parada = 0;
		String nom = null;
		String ubicacio = null;
		String informacion = null;

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.paradas WHERE nom = '"+nomb+"';");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				id_parada = rs.getInt("id_parada");
				nom = rs.getString("nom");
				ubicacio = rs.getString("ubicacio");
				informacion = rs.getString("informacion");
				

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		Parada  pa = new Parada(id_parada, nom, ubicacio, informacion);
		return pa;
	}
	
	
	
	public void insertaParada(Parada pa) { // insertar parada

		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);


			 int id_parada = pa.getId_parada();
			 String nom = pa.getNom();
			 String ubicacio = pa.getUbicacio();
			 String informacion = pa.getInformacion();

			
			PreparedStatement query = con.prepareStatement(
					" INSERT INTO autobusos.paradas (id_parada, nom, ubicacio, informacion) VALUES (' "
							+ id_parada + " ','" + nom + "','"+ ubicacio +"','" + informacion + "') ");

			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
		}
	}
	
	
	public void deleteParada(int id) {		
		
		String query = "DELETE FROM autobusos.paradas WHERE id_parada = '"+id+"' ";
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
		
	}
	
	
	
	
	
	public void actualitzaParada(Parada pa, int id) {   //actualitza la parada

		 String nom = pa.getNom();
		 String informacion = pa.getInformacion();
		 String ubicacio = pa.getUbicacio();

		String query = "UPDATE autobusos.paradas SET nom='"+nom+"', informacion='"+informacion+"', ubicacio='"+ubicacio+"' WHERE id_parada='"+id+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);
			
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.execute();

			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
		}
		
	}
	
	
	//**********************************************************************************************
	//***************************************      ASIGNACIONS      ************************************
	//**********************************************************************************************
		
		
		public ArrayList<Asignacion> getAsignacions() {

			ArrayList<Asignacion> par = new ArrayList<Asignacion>();


			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);

				PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.asignacions");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					Asignacion para = new Asignacion(rs.getInt("id_asignacio"),
											  		 rs.getInt("id_usuari"),
											  		 rs.getInt("id_liniaruta"),
											  		 rs.getString("nom"),
											  		 rs.getString("tipus"),
											  		 rs.getString("fecha"));
					
					par.add(para);

				}
				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode());
			}
			return par;
		}
	
		
		
		
		public Asignacion getAsignacioById(int id) {

			Connection con;

			int id_asignacio = 0;
			int id_usuari = 0;
			int id_liniaruta = 0;
			String nom = null;
			String tipus = null;
			String fecha = null;


			try {
				con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);

				PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.asignacions WHERE id_asignacio = '" + id + "'");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {

					id_asignacio = rs.getInt("id_asignacio");
					id_usuari = rs.getInt("id_usuari");
					id_liniaruta = rs.getInt("id_liniaruta");
					nom = rs.getString("nom");
					tipus = rs.getString("tipus");
					fecha = rs.getString("fecha");

				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

			Asignacion  as = new Asignacion(id_asignacio, id_usuari, id_liniaruta, nom, tipus, fecha);

			return as;
		}
		
		
		
		

		public ArrayList<Asignacion> getAsignacionsByUserId(int id) {

			ArrayList<Asignacion> as = new ArrayList<Asignacion>();


			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);

				PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.asignacions WHERE id_usuari = '"+id+"';");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					Asignacion asi = new Asignacion(rs.getInt("id_asignacio"),
											   rs.getInt("id_usuari"),
											   rs.getInt("id_liniaruta"),
											   rs.getString("nom"),
											   rs.getString("tipus"),
											   rs.getString("fecha"));
					

					as.add(asi);

				}
				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode());
			}
			return as;
		}
		
		
		
		
		
		public ArrayList<Asignacion> getAsignacionsByDia(String dia) {

			ArrayList<Asignacion> as = new ArrayList<Asignacion>();


			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);

				PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.asignacions WHERE fecha = '"+dia+"';");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					Asignacion asi = new Asignacion(rs.getInt("id_asignacio"),
											   rs.getInt("id_usuari"),
											   rs.getInt("id_liniaruta"),
											   rs.getString("nom"),
											   rs.getString("tipus"),
											   rs.getString("fecha"));
					

					as.add(asi);

				}
				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode());
			}
			return as;
		}
	
		
		
		public void insertaAsignacio(Asignacion as) { // insertar asignacio

			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);


				 int id_asignacio = as.getId_asignacion();
				 int id_usuari = as.getId_usuari();
				 int id_liniaruta = as.getId_liniaruta();
				 String nom = as.getNom();
				 String tipus = as.getTipus();
				 String fecha = as.getFecha();

				
				PreparedStatement query = con.prepareStatement(
						"INSERT INTO autobusos.asignacions (id_asignacio, id_usuari, id_liniaruta, nom, fecha, tipus) VALUES ('"+id_asignacio+"', '"+id_usuari+"', '"+id_liniaruta+"','"+nom+"', '"+fecha+"', '"+tipus+"');");

				query.execute();

				con.close();

			} catch (SQLException e) {
				System.err.println(e);
			}
		}
		
		
		
		
		public ArrayList<Asignacion> getAsignacionsByTipus(String tipus) {

			ArrayList<Asignacion> as = new ArrayList<Asignacion>();


			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);

				PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.asignacions WHERE tipus = '"+tipus+"';");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					Asignacion asi = new Asignacion(rs.getInt("id_asignacio"),
											   rs.getInt("id_usuari"),
											   rs.getInt("id_liniaruta"),
											   rs.getString("nom"),
											   rs.getString("tipus"),
											   rs.getString("fecha"));
					
					as.add(asi);

				}
				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode());
			}
			return as;
		}
		
		
		
		
		
		public ArrayList<Asignacion> getAsignacionsDiaUser(String dia, int id) {

			ArrayList<Asignacion> as = new ArrayList<Asignacion>();


			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);

				PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.asignacions WHERE fecha = '"+dia+"' AND id_usuari = '"+id+"';");
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {
					
					Asignacion asi = new Asignacion(rs.getInt("id_asignacio"),
											   rs.getInt("id_usuari"),
											   rs.getInt("id_liniaruta"),
											   rs.getString("nom"),
											   rs.getString("tipus"),
											   rs.getString("fecha"));
					
					as.add(asi);

				}
				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode());
			}
			return as;
		}
		
		
		
		
		
		public void actualitzaAsignacio(Asignacion as, int id) {   //actualitza la parada

			int id_usuari = as.getId_usuari();
			int id_liniaruta = as.getId_liniaruta();
			String nom = as.getNom();
			String tipus = as.getTipus();
			String fecha = as.getFecha();
			

			String query = "UPDATE autobusos.asignacions SET id_usuari ='"+id_usuari+"', id_liniaruta='"+id_liniaruta+"', nom='"+nom+"', tipus = '"+tipus+"', fecha = '"+fecha+"' WHERE id_asignacio='"+id+"'";
			
			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);
				
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.execute();

				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
			}
			
		}
		
		
		
		
		public void deletAsignacio(int id) {		
			
			String query = "DELETE FROM autobusos.asignacions WHERE id_asignacio = '"+id+"' ";
			try {
				Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
						ConstantsApi.PASS_CONNECTION);
				
				PreparedStatement stmt = con.prepareStatement(query);
				stmt.execute();

				con.close();
			}

			catch (SQLException e) {
				System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
			}
			
			
		}
		
		
		
		
		
		//**********************************************************************************************
		//***************************************      ASIGNACIONS      ************************************
		//**********************************************************************************************
			
			
			public ArrayList<Comentari> getTotsComentaris() {

				ArrayList<Comentari> co = new ArrayList<Comentari>();

				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.comentaris");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						
						Comentari com = new Comentari(rs.getInt("id_comentari"),
												  		 rs.getInt("id_resenya"),
												  		 rs.getInt("id_usuari"),
												  		 rs.getString("comentari"),
												  		 rs.getString("fecha"));
						
						co.add(com);

					}
					con.close();
				}

				catch (SQLException e) {
					System.out.println("Error en la ejecucion: " + e.getErrorCode());
				}
				return co;
			}
			
			
			public Comentari getComentariId(int id) {

				Connection con;

				int id_comentari = 0;
				int id_resenya = 0;
				int id_usuari = 0;
				String comentari = null;
				String fecha = null;


				try {
					con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.comentaris WHERE id_comentari = '" + id + "'");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {

						id_comentari = rs.getInt("id_comentari");
						id_resenya = rs.getInt("id_resenya");
						id_usuari = rs.getInt("id_usuari");
						comentari = rs.getString("comentari");
						fecha = rs.getString("fecha");

					}

				} catch (SQLException e) {
					e.printStackTrace();
				}

				Comentari  co = new Comentari(id_comentari, id_resenya, id_usuari, comentari, fecha);

				return co;
			}
			
			
			
			
			
			public ArrayList<Comentari> getComentariByUser(int user) {

				ArrayList<Comentari> co = new ArrayList<Comentari>();

				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.comentaris WHERE id_usuari ='"+user+"'");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						
						Comentari com = new Comentari(rs.getInt("id_comentari"),
												  		 rs.getInt("id_resenya"),
												  		 rs.getInt("id_usuari"),
												  		 rs.getString("comentari"),
												  		 rs.getString("fecha"));
						
						co.add(com);

					}
					con.close();
				}

				catch (SQLException e) {
					System.out.println("Error en la ejecucion: " + e.getErrorCode());
				}
				return co;
			}
			
			
			
			
			
			public void deleteComentari(int id) {		
				
				String query = "DELETE FROM autobusos.comentaris WHERE id_comentari = '"+id+"' ";
				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);
					
					PreparedStatement stmt = con.prepareStatement(query);
					stmt.execute();

					con.close();
				}

				catch (SQLException e) {
					System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
				}
				
				
			}
			
			
			
			
			public void putComentari(int id) {		
				
				String query = "DELETE FROM autobusos.comentaris WHERE id_comentari = '"+id+"' ";
				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);
					
					PreparedStatement stmt = con.prepareStatement(query);
					stmt.execute();

					con.close();
				}

				catch (SQLException e) {
					System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
				}
				
				
			}
			
			
			
			
			
			public void putComentari(Comentari com) { // insertar comentari

				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					 int id_comentari =  com.getId_comentari();
					 int id_resenya = com.getId_resenya();
					 int id_usuari = com.getId_usuari();
					 String comentari = com.getComentari();
					 String fecha = com.getFecha();
					 
					 
					PreparedStatement query = con.prepareStatement(
							"INSERT INTO autobusos.comentaris (id_comentari, id_resenya, id_usuari, comentari, fecha) VALUES ('"+id_comentari+"', '"+id_resenya+"', '"+id_usuari+"','"+comentari+"', '"+fecha+"');");

					query.execute();
					con.close();

				} catch (SQLException e) {
					System.err.println(e);
				}
			}
			
			
			
			
			public void updateComentari(Comentari com, int id) { // insertar comentari

				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					 String comentari = com.getComentari();
					 String fecha = com.getFecha();
					 
					 
					PreparedStatement query = con.prepareStatement(
							"UPDATE autobusos.comentaris SET comentari ='"+comentari+"', fecha='"+fecha+"'  WHERE id_resenya = '"+id+"'");
							
					query.execute();
					con.close();

				} catch (SQLException e) {
					System.err.println(e);
				}
			}
			
			
			
			//**********************************************************************************************
			//***********************************      PARADAS LINIA      **********************************
			//**********************************************************************************************
			
			
			
			public ArrayList<Paradalinia> getParadasLinia(int id) {

				ArrayList<Paradalinia> pal = new ArrayList<Paradalinia>();

				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.paradalinia WHERE id_linia = '"+id+"' ORDER BY ordre;");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						
						Paradalinia pa = new Paradalinia(rs.getInt("id_linia"),
												  		 rs.getInt("id_parada"),
												  		 rs.getInt("ordre"),
												  		 rs.getString("hora"));
						
						pal.add(pa);

					}
					con.close();
				}

				catch (SQLException e) {
					System.out.println("Error en la ejecucion: " + e.getErrorCode());
				}
				return pal;
			}
			
			
			
			
			
			public ArrayList<Paradalinia> getLiniasParada(int id) {

				ArrayList<Paradalinia> pal = new ArrayList<Paradalinia>();

				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.paradalinia WHERE id_parada = '"+id+"' ORDER BY ordre;");
					ResultSet rs = stmt.executeQuery();

					while (rs.next()) {
						
						Paradalinia pa = new Paradalinia(rs.getInt("id_linia"),
												  		 rs.getInt("id_parada"),
												  		 rs.getInt("ordre"),
												  		 rs.getString("hora"));
						
						pal.add(pa);

					}
					con.close();
				}

				catch (SQLException e) {
					System.out.println("Error en la ejecucion: " + e.getErrorCode());
				}
				return pal;
			}
			
			
			
			
			public void insertaParadaLinia(Paradalinia pali) { // insertar paradalinia

				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);

					 int id_linia =  pali.getId_linia();
					 int id_parada = pali.getId_parada();
					 int ordre = pali.getOrdre();
					 String hora = pali.getHora();
					 
					 
					PreparedStatement query = con.prepareStatement(
							"INSERT INTO autobusos.paradalinia (id_linia, id_parada, ordre, hora) VALUES ('"+id_linia+"', '"+id_parada+"', '"+ordre+"', '"+hora+"');");

					query.execute();
					con.close();

				} catch (SQLException e) {
					System.err.println(e);
				}
			}
			
			
			
			
			public void deleteParadaLinia(int id_parada, int id_linia) {		
				
				String query = "DELETE FROM autobusos.paradalinia WHERE id_parada = '"+id_parada+"' AND id_linia = '"+id_linia+"'";
				try {
					Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
							ConstantsApi.PASS_CONNECTION);
					
					PreparedStatement stmt = con.prepareStatement(query);
					stmt.execute();

					con.close();
				}

				catch (SQLException e) {
					System.out.println("Error en la ejecucion: " + e.getErrorCode() + "----------" + e.getMessage() + "-------" +  query);
				}
				
				
			}
			
			
			
			
			
			
			
			
			
		
		
			 
			     
			   
		
	

	public static void main(String[] args) {
		
		final String secretKey = "MEENCANTASISTEMAS";
	     
	    String originalString = "howtodoinjava.com";
	    //Encripta
	    String encryptedString = AES.encrypt(originalString, ConstantsApi.SECRETKEY) ;
	    
	    //Desencripta
	    String decryptedString = AES.decrypt(encryptedString, secretKey) ;
		
		 System.out.println(originalString);
		    System.out.println(encryptedString);
		    System.out.println(decryptedString);
		
    }
	
	
	/*
	 * 
	 * FUNCIONES COMPLEMENTARIAS
	 * 
	 * **********FUNCIONS QUE REQUEREIXIN ID FICAR COMPROBANT DE EXISTENCIA************** 
	 * 
	 * 
	 * 
	 * */
	
	
}



