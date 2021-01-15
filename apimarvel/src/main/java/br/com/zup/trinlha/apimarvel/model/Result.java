package br.com.zup.trinlha.apimarvel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Result {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("title")
	private String title;
	
	@JsonProperty("resourceURI")
	private String resourceURI;

}
