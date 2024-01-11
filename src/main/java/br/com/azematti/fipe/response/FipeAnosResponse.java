package br.com.azematti.fipe.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FipeAnosResponse {

	@JsonProperty("codigo")
	private String codigo;
	
	@JsonProperty("nome")
	private String nome;
}
