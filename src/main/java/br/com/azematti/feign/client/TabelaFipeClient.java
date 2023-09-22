package br.com.azematti.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.azematti.model.FipeMarcas;
import br.com.azematti.model.wrapper.FipeModelosWrapper;

@Component
@FeignClient(name = "veiculosFipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface TabelaFipeClient {

	@GetMapping(value = "/carros/marcas")
	List<FipeMarcas> buscaTodosVeiculos();
	
	@GetMapping(value = "/carros/marcas/{marcaCodigo}/modelos", produces = {MediaType.APPLICATION_JSON_VALUE})
	ResponseEntity<FipeModelosWrapper> buscaModelosVeiculo(@PathVariable String marcaCodigo);
}
