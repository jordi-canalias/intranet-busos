package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Asignacion {
	
	@JsonProperty("id_asignacion")
	private int id_asignacion;
	@JsonProperty("id_usuari")
	private int  id_usuari;
	@JsonProperty("nom_usuari")
	private String  nom_usuari;
	@JsonProperty("tipus")
	private String  tipus;
	@JsonProperty("id_linia")
	private String  id_linia;
	@JsonProperty("nom_linia")
	private String  nom_linia;
	@JsonProperty("dias_asignats")
	private String  dias_asignats;   //arraylist de fechas cambiar quan formategi la base de dades a dates
	


	
	@JsonCreator
	public Asignacion(
			@JsonProperty("id_asignacion") final int id_asignacion,
			@JsonProperty("id_usuari") final int  id_usuari,
			@JsonProperty("nom_usuari") final String nom_usuari,
			@JsonProperty("tipus") final String tipus,
			@JsonProperty("id_linia") final String id_linia,
			@JsonProperty("nom_linia") final String nom_linia,
			@JsonProperty("dias_asignats") final String dias_asignats
				) {
		this.id_asignacion = id_asignacion;
		this.id_usuari = id_usuari;
		this.nom_usuari = nom_usuari;
		this.tipus = tipus;
		this.id_linia = id_linia;
		this.nom_linia = nom_linia;
		this.dias_asignats = dias_asignats;
	}


	@JsonProperty("id_asignacion")
	public int getId_asignacion() {
		return id_asignacion;
	}


	@JsonProperty("id_usuari")
	public int getId_usuari() {
		return id_usuari;
	}


	@JsonProperty("nom_usuari")
	public String getNom_usuari() {
		return nom_usuari;
	}


	@JsonProperty("tipus")
	public String getTipus() {
		return tipus;
	}


	@JsonProperty("id_linia")
	public String getId_linia() {
		return id_linia;
	}


	@JsonProperty("nom_linia")
	public String getNom_linia() {
		return nom_linia;
	}


	@JsonProperty("dias_asignats")
	public String getDias_asignats() {
		return dias_asignats;
	}


	
	

}
