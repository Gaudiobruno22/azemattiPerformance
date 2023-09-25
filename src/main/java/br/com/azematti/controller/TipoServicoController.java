package br.com.azematti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.model.TipoServico;
import br.com.azematti.service.TipoServicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/tiposervico")
@AllArgsConstructor
@Api(value = "Tipo de Serviço Contratado.", description = "É uma Foreign Key para Classificar os Serviços efetivados.", 
tags = "TpServicoController")
public class TipoServicoController {

	private TipoServicoService service;
	
	private static final Logger logger = LoggerFactory.getLogger(TipoServicoController.class);
	
	@ApiOperation(value = "Insere um Novo Tipo de Serviço.")
	@PostMapping(value = "/insere")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Void> insereTipoServico(@RequestBody TipoServico tpServico){
		try {
			service.insereTipoServico(tpServico);
			return ResponseEntity.noContent().build();
		}
		catch(Exception e) {
			logger.error("{}" ,e);
			return ResponseEntity.badRequest().build();
		}
	}
	
	@ApiOperation(value = "Busca um Tipo de Serviço pelo ID.")
	@GetMapping(value = "/busca/{id}")
	public ResponseEntity<TipoServico> buscaTpServico(@PathVariable Long id){
		TipoServico tpServico = new TipoServico();
		try {
			tpServico = service.buscaTpServico(id);
		}
		catch(Exception e) {
			e.getMessage();
		}
		return ResponseEntity.ok(tpServico);
	}
}
