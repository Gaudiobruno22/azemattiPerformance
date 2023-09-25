package br.com.azematti.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.model.FipeAnos;
import br.com.azematti.model.FipeDados;
import br.com.azematti.model.FipeMarcas;
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
	
	@ApiOperation(value = "Buscar Marcas de Carros.")
	@GetMapping(value = "/busca")
	public ResponseEntity<List<FipeMarcas>> buscaVeiculo(){
		List<FipeMarcas> list = clientService.buscaVeiculos();
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
	public ResponseEntity<List<FipeAnos>> buscaAnoModelo(@PathVariable String marcaCodigo,
														 @PathVariable String modeloCodigo){
		
		List<FipeAnos> list = clientService.buscaAnoVeiculo(marcaCodigo, modeloCodigo);
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation(value = "Faz a Consulta e Retorna o Valor Fipe do Veículo.")
	@GetMapping(value = "/fipe/busca/{marcaCodigo}/modelo/{modeloCodigo}/ano/{anoCodigo}")
	public ResponseEntity<FipeDados> buscaFipe(@PathVariable String marcaCodigo,
													@PathVariable String modeloCodigo,
													@PathVariable String anoCodigo){
		
		FipeDados fipe = clientService.retornaValorFipe(marcaCodigo, modeloCodigo, anoCodigo);
		return ResponseEntity.ok(fipe);
	}
}
