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
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/azematti/client")
public class ClientController {

	private FipeService clientService;
	
	@GetMapping(value = "/busca")
	public ResponseEntity<List<FipeMarcas>> buscaVeiculo(){
		List<FipeMarcas> list = clientService.buscaVeiculos();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/modelos/{marcaCodigo}")
	public ResponseEntity<FipeModelosWrapper> buscaModelosVeiculo(@PathVariable String marcaCodigo){
		FipeModelosWrapper list = clientService.buscaTodosModelos(marcaCodigo);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/ano/marca/{marcaCodigo}/ano/{modeloCodigo}")
	public ResponseEntity<List<FipeAnos>> buscaAnoModelo(@PathVariable String marcaCodigo,
														 @PathVariable String modeloCodigo){
		
		List<FipeAnos> list = clientService.buscaAnoVeiculo(marcaCodigo, modeloCodigo);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/fipe/busca/{marcaCodigo}/modelo/{modeloCodigo}/ano/{anoCodigo}")
	public ResponseEntity<FipeDados> buscaFipe(@PathVariable String marcaCodigo,
													@PathVariable String modeloCodigo,
													@PathVariable String anoCodigo){
		
		FipeDados fipe = clientService.retornaValorFipe(marcaCodigo, modeloCodigo, anoCodigo);
		return ResponseEntity.ok(fipe);
	}
}
