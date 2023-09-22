package br.com.azematti.model.wrapper;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.azematti.model.FipeModelos;
import lombok.Data;

@Data
public class FipeModelosWrapper {

	@JsonProperty("modelos")
	private List<FipeModelos> fipeModelos;
}
