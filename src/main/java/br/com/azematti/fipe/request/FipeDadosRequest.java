package br.com.azematti.fipe.request;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FipeDadosRequest implements Serializable{
	private static final long serialVersionUID = 1L;

	private String marcaCodigo;
	private String modeloCodigo;
	private String anoCodigo;
}
