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
import java.util.ArrayList;

import config.ConstantsApi;
import model.*;


public class DatabaseDao {
	
	

	/*
	 * 
	 * Actualitzat 
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





	public Boolean checkUsuari(Usuari us) {
		
		int id = us.getId_usuari();
		String pass = us.getContrasenya();
		
		ArrayList<Usuari> users = new ArrayList<Usuari>();
		
		
		//SELECT * FROM autobusos.usuaris WHERE id_usuari='-1' and contrasenya='1234'
		
		
		try {
			Connection con = DriverManager.getConnection(ConstantsApi.CONNECTION, ConstantsApi.USER_CONNECTION,
					ConstantsApi.PASS_CONNECTION);

			PreparedStatement stmt = con.prepareStatement("SELECT * FROM autobusos.usuaris WHERE id_usuari='"+id+"' and contrasenya='"+pass+"'");
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
	
	
	
	
	
	
	
	
	/*
	 * 
	 * FUNCIONES COMPLEMENTARIAS
	 * 
	 * 
	 * */
	
	
}



