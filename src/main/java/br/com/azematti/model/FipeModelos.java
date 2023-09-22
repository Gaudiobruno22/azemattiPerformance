package br.com.azematti.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FipeModelos implements Serializable{
	private static final long serialVersionUID = 1L;

	@JsonProperty("codigo")
	private String codigo;
	
	@JsonProperty("nome")
	private String nome;
}
