package br.com.azematti.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FipeAnos {

	@JsonProperty("codigo")
	private String codigo;
	
	@JsonProperty("nome")
	private String nome;
}
