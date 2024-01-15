package br.com.azematti.fipe.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class FipeDadosResponse {

	@JsonProperty("TipoVeiculo")
	private Long tipoVeiculo;
	
	@JsonProperty("Valor")
	private String valor;
	
	@JsonProperty("Marca")
	private String marca;
	
	@JsonProperty("Modelo")
	private String modelo;
	
	@JsonProperty("AnoModelo")
	private Integer anoModelo;
	
	@JsonProperty("Combustivel")
	private String combustivel;
	
	@JsonProperty("CodigoFipe")
	private String codigoFipe;
	
	@JsonProperty("MesReferencia")
	private String mesRef;
	
	@JsonProperty("SiglaCombustivel")
	private String siglaCombustivel;
}
