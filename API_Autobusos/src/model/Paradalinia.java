package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Paradalinia {

	@JsonProperty("id_linia")
	private int id_linia;
	@JsonProperty("id_parada")
	private int id_parada;


	
	@JsonCreator
	public Paradalinia(
			@JsonProperty("id_linia") final int id_linia,
			@JsonProperty("id_parada") final int id_parada		
			) {
		this.id_linia = id_linia;
		this.id_parada = id_parada;
	}


	@JsonProperty("id_linia")
	public int getId_linia() {
		return id_linia;
	}


	@JsonProperty("id_parada")
	public int getId_parada() {
		return id_parada;
	}


	

	
}
