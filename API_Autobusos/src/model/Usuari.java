package model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Usuari {


	@JsonProperty("id_usuari")
	private int id_usuari;
	@JsonProperty("nom")
	private String nom;
	@JsonProperty("cognoms")
	private String cognoms;
	@JsonProperty("funcio")
	private String funcio;
	@JsonProperty("fecha_entrada")
	private String fecha_entrada;
	@JsonProperty("telefon")
	private String telefon;
	@JsonProperty("correu_electronic")
	private String correu_electronic;
	@JsonProperty("permisos")
	private String permisos;
	@JsonProperty("contrasenya")
	private String contrasenya;

	

	
	@JsonCreator
	public Usuari(
			@JsonProperty("id_usuari") final int id_usuari,
			@JsonProperty("nom") final String nom,
			@JsonProperty("cognoms") final String cognoms,
			@JsonProperty("funcio") final String funcio,
			@JsonProperty("fecha_entrada") final String fecha_entrada,
			@JsonProperty("telefon") final String telefon,
			@JsonProperty("correu_electronic") final String correu_electronic,
			@JsonProperty("permisos") final String permisos,
			@JsonProperty("contrasenya") final String contrasenya
			) {
		this.id_usuari = id_usuari;
		this.nom = nom;
		this.funcio = funcio;
		this.cognoms = cognoms;
		this.fecha_entrada = fecha_entrada;
		this.telefon = telefon;
		this.correu_electronic = correu_electronic;
		this.permisos = permisos;
		this.contrasenya = contrasenya;
	}



	@JsonProperty("id_usuari")
	public int getId_usuari() {
		return id_usuari;
	}



	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}



	@JsonProperty("cognoms")
	public String getCognoms() {
		return cognoms;
	}



	@JsonProperty("funcio")
	public String getFuncio() {
		return funcio;
	}



	@JsonProperty("fecha_entrada")
	public String getFecha_entrada() {
		return fecha_entrada;
	}



	@JsonProperty("telefon")
	public String getTelefon() {
		return telefon;
	}



	@JsonProperty("correu_electronic")
	public String getCorreu_electronic() {
		return correu_electronic;
	}


	@JsonProperty("contrasenya")
	public String getContrasenya() {
		return contrasenya;
	}



	@JsonProperty("permisos")
	public String getPermisos() {
		return permisos;
	}
	
	
	
}
