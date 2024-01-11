package br.com.azematti.fipe.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FipeAnosRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String marcaCodigo;
	private String modeloCodigo;
}
