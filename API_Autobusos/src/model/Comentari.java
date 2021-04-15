package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Comentari {


	@JsonProperty("id_comentari")
	private int id_comentari;
	@JsonProperty("id_resenya")
	private int id_resenya;
	@JsonProperty("id_usuari")
	private int id_usuari;
	@JsonProperty("comentari")
	private String comentari;
	

	
	@JsonCreator
	public Comentari(
			@JsonProperty("id_comentari") final int id_comentari,
			@JsonProperty("id_resenya") final int id_resenya,
			@JsonProperty("id_usuari") final int id_usuari,
			@JsonProperty("comentari") final String comentari
			) {
		this.id_comentari = id_comentari;
		this.id_resenya = id_resenya;
		this.id_usuari = id_usuari;
		this.comentari = comentari;
	}


	@JsonProperty("id_comentari")
	public int getId_comentari() {
		return id_comentari;
	}


	@JsonProperty("id_resenya")
	public int getId_resenya() {
		return id_resenya;
	}


	@JsonProperty("id_usuari")
	public int getId_usuari() {
		return id_usuari;
	}


	@JsonProperty("comentari")
	public String getComentari() {
		return comentari;
	}


	

	
}
