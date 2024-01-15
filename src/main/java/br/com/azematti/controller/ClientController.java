package br.com.azematti.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.fipe.request.FipeAnosRequest;
import br.com.azematti.fipe.request.FipeModelosRequest;
import br.com.azematti.fipe.response.FipeAnosResponse;
import br.com.azematti.fipe.response.FipeDadosResponse;
import br.com.azematti.fipe.response.FipeMarcasResponse;
import br.com.azematti.model.wrapper.FipeModelosWrapper;
import br.com.azematti.service.FipeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/azematti/client")
@Api(value = "EndPoint da API de Tabela Fipe.", description = "EndPoints para Comunicação com a API de Consulta Fipe", tags = "FipeController")
public class ClientController {

	private FipeService clientService;
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@ApiOperation(value = "Buscar Marcas de Carros.")
	@GetMapping(value = "/busca")
	public ResponseEntity<List<FipeMarcasResponse>> buscaVeiculo(){
		List<FipeMarcasResponse> list = clientService.buscaVeiculos();
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation(value = "Buscar Modelos de Veículo.")
	@GetMapping(value = "/modelos/{marcaCodigo}")
	public ResponseEntity<FipeModelosWrapper> buscaModelosVeiculo(@PathVariable String marcaCodigo){
		FipeModelosWrapper list = clientService.buscaTodosModelos(marcaCodigo);
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation(value = "Busca o ano específico do Veículo Selecionado.")
	@GetMapping(value = "/ano/marca/{marcaCodigo}/ano/{modeloCodigo}")
	public ResponseEntity<List<FipeAnosResponse>> buscaAnoModelo(@PathVariable String marcaCodigo,
														 	     @PathVariable String modeloCodigo){
		List<FipeAnosResponse> response = clientService.buscaAnoVeiculo(marcaCodigo, modeloCodigo);
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Faz a Consulta e Retorna o Valor Fipe do Veículo.")
	@GetMapping(value = "/fipe/busca/{marcaCodigo}/modelo/{modeloCodigo}/ano/{anoCodigo}")
	public ResponseEntity<FipeDadosResponse> buscaFipe(@PathVariable String marcaCodigo,
													@PathVariable String modeloCodigo,
													@PathVariable String anoCodigo){
		FipeDadosResponse fipe = clientService.retornaValorFipe(marcaCodigo, modeloCodigo, anoCodigo);
		logger.info("To saindo da Service??" + marcaCodigo);
		return ResponseEntity.ok(fipe);
	}
}
