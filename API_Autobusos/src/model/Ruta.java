package model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Ruta {

	@JsonProperty("id_ruta")
	private int id_ruta;
	@JsonProperty("nom")
	private String nom;
	@JsonProperty("caracter")
	private String caracter;
	@JsonProperty("client")
	private String client;
	@JsonProperty("recollida")
	private String recollida;
	@JsonProperty("destinacio")
	private String destinacio;
	@JsonProperty("informacion")
	private String informacion;
	@JsonProperty("guia_asignat")
	private String guia_asignat;


	
	public Ruta(@JsonProperty("id_ruta")  int id_ruta,
			@JsonProperty("nom")  String nom,
			@JsonProperty("caracter")  String caracter,
			@JsonProperty("client")  String client,
			@JsonProperty("recollida")  String recollida,
			@JsonProperty("destinacio")  String destinacio,
			@JsonProperty("informacion")  String informacion,
			@JsonProperty("guia_asignat")  String guia_asignat
			) {
		this.id_ruta = id_ruta;
		this.nom = nom;
		this.caracter = caracter;
		this.client = client;
		this.recollida = recollida;
		this.destinacio = destinacio;
		this.informacion = informacion;
		this.guia_asignat = guia_asignat;
	}



	@JsonProperty("id_ruta")
	public int getId_ruta() {
		return id_ruta;
	}

	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}


	@JsonProperty("caracter")
	public String getCaracter() {
		return caracter;
	}
	
	@JsonProperty("client")
	public String getClient() {
		return client;
	}


	@JsonProperty("destinacio")
	public String getDestinacio() {
		return destinacio;
	}


	@JsonProperty("informacion")
	public String getInformacion() {
		return informacion;
	}


	@JsonProperty("guia_asignat")
	public String getGuia_asignat() {
		return guia_asignat;
	}

/*
	@JsonProperty("paradas")
	public String getParadas() {
		return paradas;
	}
*/

	@JsonProperty("recollida")
	public String getRecollida() {
		return recollida;
	}
	
	
	
}
