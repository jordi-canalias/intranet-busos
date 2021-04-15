package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Resenya {
	
	@JsonProperty("id_resenya")
	private int id_resenya;
	@JsonProperty("nom")
	private String nom;
	@JsonProperty("id_usuari")
	private int id_usuari;
	@JsonProperty("fecha")
	private String fecha;
	@JsonProperty("informacion")
	private String informacion;
	@JsonProperty("links")
	private String links;
	@JsonProperty("hastags")
	private String hastags;


	
	public Resenya(
			@JsonProperty("id_resenya") final int id_resenya,
			@JsonProperty("nom") final String nom,
			@JsonProperty("id_usuari") final int id_usuari,
			@JsonProperty("fecha") final String fecha,
			@JsonProperty("informacion") final String informacion,
			@JsonProperty("links") final String links,
			@JsonProperty("hastags") final String hastags
			) {
		this.id_resenya = id_resenya;
		this.nom = nom;
		this.nom = nom;
		this.id_usuari = id_usuari;
		this.fecha = fecha;
		this.informacion = informacion;
		this.links = links;
		this.hastags = hastags;
	}


	@JsonProperty("id_resenya")
	public int getId_resenya() {
		return id_resenya;
	}


	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}


	@JsonProperty("id_usuari")
	public int getId_usuari() {
		return id_usuari;
	}


	@JsonProperty("fecha")
	public String getFecha() {
		return fecha;
	}


	@JsonProperty("informacion")
	public String getInformacion() {
		return informacion;
	}


	@JsonProperty("links")
	public String getLinks() {
		return links;
	}


	@JsonProperty("hastags")
	public String getHastags() {
		return hastags;
	}
	
	

}
