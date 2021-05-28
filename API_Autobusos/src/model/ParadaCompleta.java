package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ParadaCompleta {

	@JsonProperty("id_linia")
	private int id_linia;
	@JsonProperty("id_parada")
	private int id_parada;
	@JsonProperty("ordre")
	private int ordre;
	@JsonProperty("hora")
	private String hora;
	@JsonProperty("ubicacio")
	private String ubicacio;
	@JsonProperty("informacion")
	private String informacion;
	@JsonProperty("nom")
	private String nom;
	


	
	@JsonCreator
	public ParadaCompleta(
			@JsonProperty("id_linia") final int id_linia,
			@JsonProperty("id_parada") final int id_parada,
			@JsonProperty("ordre") final int ordre,
			@JsonProperty("hora") final String hora,
			@JsonProperty("ubicacio") final String ubicacio,
			@JsonProperty("informacion") final String informacion,
			@JsonProperty("nom") final String nom
			) {
		this.id_linia = id_linia;
		this.id_parada = id_parada;
		this.ordre = ordre;
		this.hora = hora;
		this.ubicacio = ubicacio;
		this.informacion = informacion;
		this.nom = nom;
	}


	@JsonProperty("id_linia")
	public int getId_linia() {
		return id_linia;
	}

	@JsonProperty("id_parada")
	public int getId_parada() {
		return id_parada;
	}
	
	@JsonProperty("ordre")
	public int getOrdre() {
		return ordre;
	}

	@JsonProperty("hora")
	public String getHora() {
		return hora;
	}


	@JsonProperty("ubicacio")
	public String getUbicacio() {
		return ubicacio;
	}

	
	@JsonProperty("informacion")
	public String getInformacion() {
		return informacion;
	}

	
	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}


	

	
}
