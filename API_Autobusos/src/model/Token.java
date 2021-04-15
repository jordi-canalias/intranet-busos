package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Token {

	@JsonProperty("id_usuari")
	int id_usuari;
	@JsonProperty("usuari")
	String usuari;
	@JsonProperty("token")
	String token;
	@JsonProperty("hora_inici")
    String hora_inici;
    
	

	@JsonCreator
	public Token(
			@JsonProperty("id_usuari") final int id_usuari,
			@JsonProperty("nusuariom") final String usuari,
			@JsonProperty("token") final String token,
			@JsonProperty("hora_inici") final String hora_inici) {
		this.id_usuari = id_usuari;
		this.usuari = usuari;
		this.token = token;
		this.hora_inici = hora_inici;
	}


	@JsonProperty("id_usuari")
	public int getId_usuari() {
		return id_usuari;
	}


	@JsonProperty("usuari")
	public String getUsuari() {
		return usuari;
	}


	@JsonProperty("token")
	public String getToken() {
		return token;
	}


	@JsonProperty("hora_inici")
	public String getHora_inici() {
		return hora_inici;
	}
    
    
	
}
