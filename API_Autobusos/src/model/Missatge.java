package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Missatge {


	@JsonProperty("missatge")
	private String missatge;


	@JsonCreator
	public Missatge(
			@JsonProperty("missatge") final String missatge) {		
		this.missatge = missatge;
	}
	
	@JsonProperty("missatge")
	public String getMissatge() {
		return missatge;
	}
	
	
}
