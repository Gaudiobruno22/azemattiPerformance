package br.com.azematti.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Data
public class FipeMarcas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("codigo")
	private String codigo;
	
	@JsonProperty("nome")
	private String nome;

}
