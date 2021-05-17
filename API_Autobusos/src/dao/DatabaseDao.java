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
	
	

	/*
	 * 
	 * Actualitzat 28/04/2021
	 * 
	 */
	
	
	
	
	

	
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
	
	
	
	
	
	
	
	
	
	
	public void deleteRuta(int id) {

		String data = "now";
		
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

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.linias");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Linia li = new Linia(rs.getInt("id_lina"),rs.getString("nom"),rs.getString("informacion"),rs.getString("bus_asignat"),
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
					" INSERT INTO autobusos.linias (id_linia, nom, informacion, bus_asginat, hora_inici, hora_finalitzacio) VALUES (' "
							+ id_linia + " ','" + nom + "','"+ informacion +"','" + bus_asignat + "','" + hora_inici + "','" + hora_finalitzacio
							+ "') ");

			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
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
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getInt("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

				users.add(us);

			}
			con.close();
		}

		catch (SQLException e) {
			System.out.println("Error en la ejecucion: " + e.getErrorCode());
		}
		return users;
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
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getInt("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

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
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getInt("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

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

		int id_usuari = us.getId_usuari();
		
		//UPDATE autobusos.tokens SET token='"+to+"', hora_inici='"+data+"' WHERE id_usuari='"+id_usuari+"';
		
		/*
		java.util.Date date = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		String data = String.valueOf(hours);
		*/
		
		String data = "now";
		
		String query = "UPDATE autobusos.tokens SET token='"+to+"', hora_inici='"+data+"' WHERE id_usuari='"+id_usuari+"'";
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			
			System.out.print(to);
			System.out.print(data);
			System.out.print(id_usuari);
			
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
		int id = to.getId_usuari();
		String token = to.getToken();
		
		ArrayList<Token> tokens = new ArrayList<Token>();
		
		
		//SELECT * FROM autobusos.usuaris WHERE id_usuari='-1' and contrasenya='1234'
		
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.tokens WHERE id_usuari='"+id+"' and token='"+token+"'");
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
						rs.getString("funcio"),rs.getString("fecha_entrada"),rs.getInt("telefon"),rs.getString("correuElectronic"),rs.getString("permisos"),rs.getString("contrasenya"));
				

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
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
		LocalDateTime now = LocalDateTime.now();  
		//dtf.format(now);
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);


			int id_linia = 0;
			String nom = us.getNom();
			String cognoms = us.getCognoms();
			String funcio = us.getFuncio();
			String fecha_entrada = dtf.format(now);
			int telefon = us.getTelefon();
			String correuElectronic  = us.getCorreu_electronic();
			String permisos = us.getPermisos();
			String contrasenya = us.getContrasenya();
			
			
			if(comprobaNomRepetit(nom)) {
				return false;
				
			}
			
			PreparedStatement query = con.prepareStatement(
					" INSERT INTO autobusos.usuaris (id_usuari, nom, cognoms, funcio, fecha_entrada, telefon, correuElectronic, permisos, contrasenya) VALUES (' "
							+ id_linia + " ','" + nom + "','"+ cognoms +"','" + funcio + "','" + fecha_entrada + "','" + telefon+ "','" + correuElectronic+ "','" + permisos+ "','" + contrasenya+ "') ");

			query.execute();

			con.close();

		} catch (SQLException e) {
			System.err.println(e);
		}
		
		return true;
	}
	
	
	
	
	
	public void actualitzaUsuari(Usuari newUs, String nomUsuari) {

		
		String nom = newUs.getNom();
		String cognoms = newUs.getCognoms();
		String funcio = newUs.getFuncio();
		String fecha_entrada = newUs.getFecha_entrada();
		int telefon = newUs.getTelefon();
		String correuElectronic  = newUs.getCorreu_electronic();
		String permisos = newUs.getPermisos();
		String contrasenya = newUs.getContrasenya();
		
		
		String query = "UPDATE autobusos.usuaris SET nom ='"+nom+"', cognoms='"+cognoms+"', funcio='"+funcio+"', telefon='"+telefon+"', correuElectronic='"+correuElectronic+"', contrasenya='"+contrasenya+"' WHERE nom='"+nomUsuari+"'";
		
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

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
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
	
	
	/*
	public static void main(String[] args) {
		System.out.print(getParadaByNom("San cugat").getNom());
		System.out.print(getParadaByNom("test3").getId_parada());
    }
	*/
	
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



