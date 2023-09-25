package br.com.azematti.feign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.azematti.model.FipeAnos;
import br.com.azematti.model.FipeDados;
import br.com.azematti.model.FipeMarcas;
import br.com.azematti.model.wrapper.FipeModelosWrapper;

@Component
@FeignClient(name = "veiculosFipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface TabelaFipeClient {

	@GetMapping(value = "/carros/marcas", produces = {MediaType.APPLICATION_JSON_VALUE})
	List<FipeMarcas> buscaTodosVeiculos();
	
	@GetMapping(value = "/carros/marcas/{marcaCodigo}/modelos", produces = {MediaType.APPLICATION_JSON_VALUE})
	ResponseEntity<FipeModelosWrapper> buscaModelosVeiculo(@PathVariable String marcaCodigo);
	
	@GetMapping(value = "/carros/marcas/{marcaCodigo}/modelos/{modeloCodigo}/anos", produces = {MediaType.APPLICATION_JSON_VALUE})
	List<FipeAnos> buscaAnoModelo(@PathVariable String marcaCodigo, 
								  @PathVariable String modeloCodigo);
	
	@GetMapping(value = "/carros/marcas/{marcaCodigo}/modelos/{modeloCodigo}/anos/{anoCodigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	FipeDados consultaValorFipe(@PathVariable String marcaCodigo,
								@PathVariable String modeloCodigo,
								@PathVariable String anoCodigo);
}
