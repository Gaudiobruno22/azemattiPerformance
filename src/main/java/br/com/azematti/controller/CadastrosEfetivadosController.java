package br.com.azematti.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.model.CadastrosEfetivados;
import br.com.azematti.service.CadastrosEfetivadosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cadastro")
@AllArgsConstructor
@Api(value = "EndPoint dos Cadastros Efetivados.", description = "Cadastros Efetivados - Busca de Todos Cadastros Na Base.", tags = "CadastrosEfetivados")
public class CadastrosEfetivadosController {

	private CadastrosEfetivadosService cadastroService;
	
	private static final Logger logger = LoggerFactory.getLogger(CadastrosEfetivadosController.class);
	
	
	@ApiOperation(value = "Busca todos Cadastros Efetivados.")
	@GetMapping(value = "/todos")
	public ResponseEntity<List<CadastrosEfetivados>> buscaCadastros(){
		List<CadastrosEfetivados> list = cadastroService.buscaTodos();
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation(value = "Efetiva uma Solicitação de Cadastro para um Cadastro efetivado.")
	@GetMapping(value = "/efetiva/solicitacao/{solCadastroCodigo}")
	public ResponseEntity<CadastrosEfetivados> efetivaSolicitacao(@PathVariable Long solCadastroCodigo){
		logger.info("Controller Efetiva Solicitação.");
		CadastrosEfetivados cad = new CadastrosEfetivados();
		try {
			cad = cadastroService.efetivaSolicitacao(solCadastroCodigo);
		}catch(Exception e) {
			logger.error("Erro Controller efetivaSolicitacao. ERRO.: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.ok(cad);
	}
}
