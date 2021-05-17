package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Parada {


	@JsonProperty("id_parada")
	private int id_parada;
	@JsonProperty("nom")
	private String nom;
	@JsonProperty("ubicacio")
	private String ubicacio;
	@JsonProperty("informacion")
	private String informacion;
	

	
	@JsonCreator
	public Parada(
			@JsonProperty("id_parada") final int id_parada,
			@JsonProperty("nom") final String nom,
			@JsonProperty("ubicacio") final String ubicacio,
			@JsonProperty("informacion") final String informacion
			) {
		this.id_parada = id_parada;
		this.nom = nom;
		this.ubicacio = ubicacio;
		this.informacion = informacion;
	}


	public Parada() {
		// TODO Auto-generated constructor stub
	}


	@JsonProperty("id_parada")
	public int getId_parada() {
		return id_parada;
	}


	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}


	@JsonProperty("ubicacio")
	public String getUbicacio() {
		return ubicacio;
	}


	@JsonProperty("informacion")
	public String getInformacion() {
		return informacion;
	}
	
	
}
