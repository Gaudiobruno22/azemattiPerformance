package br.com.azematti.fipe.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FipeModelosRequest implements Serializable{
	private static final long serialVersionUID = 1L;

	private String marcaCodigo;
}
