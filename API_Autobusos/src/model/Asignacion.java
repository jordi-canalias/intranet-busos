package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Asignacion {
	
	@JsonProperty("id_asignacion")
	private int id_asignacion;
	@JsonProperty("id_usuari")
	private int  id_usuari;
	@JsonProperty("id_liniaruta")
	private int  id_liniaruta;
	@JsonProperty("nom")
	private String  nom;
	@JsonProperty("tipus")
	private String  tipus;
	@JsonProperty("fecha")
	private String  fecha;
	
	
	
	
	
	
	@JsonCreator
	public Asignacion(
			@JsonProperty("id_asignacion") final int id_asignacion,
			@JsonProperty("id_usuari") final int  id_usuari,
			@JsonProperty("id_liniaruta") final int id_liniaruta,
			@JsonProperty("nom") final String nom,
			@JsonProperty("tipus") final String tipus,
			@JsonProperty("fecha") final String fecha
				) {
		this.id_asignacion = id_asignacion;
		this.id_usuari = id_usuari;
		this.id_liniaruta = id_liniaruta;
		this.nom = nom;
		this.tipus = tipus;
		this.fecha = fecha;
	}





	@JsonProperty("id_asignacion")
	public int getId_asignacion() {
		return id_asignacion;
	}





	@JsonProperty("id_usuari")
	public int getId_usuari() {
		return id_usuari;
	}





	@JsonProperty("id_liniaruta")
	public int getId_liniaruta() {
		return id_liniaruta;
	}





	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}





	@JsonProperty("tipus")
	public String getTipus() {
		return tipus;
	}





	@JsonProperty("fecha")
	public String getFecha() {
		return fecha;
	}

}
