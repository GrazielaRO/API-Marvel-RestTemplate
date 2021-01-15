package br.com.zup.trinlha.apimarvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class GeneralResponse {
	
	@JsonProperty("copyright")
	private String copyright;
	
	@JsonProperty("attributionText")
	private String attributionText;
	
	@JsonProperty("attributionHTML")
	private String attributionHTML;
	
	@JsonProperty("data")
	private DataResponse data;

}
