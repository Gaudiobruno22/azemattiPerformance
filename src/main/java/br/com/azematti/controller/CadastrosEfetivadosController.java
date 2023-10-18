package br.com.azematti.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.model.CadastrosEfetivados;
import br.com.azematti.model.SolicitacaoCadastro;
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
	
	@ApiOperation(value = "Busca todos Cadastros Efetivados.")
	@GetMapping(value = "/todos")
	public ResponseEntity<List<CadastrosEfetivados>> buscaCadastros(){
		List<CadastrosEfetivados> list = cadastroService.buscaTodos();
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation(value = "Efetiva uma Solicitação de Cadastro para um Cadastro efetivado.")
	@PostMapping(value = "/efetiva/solicitacao")
	public ResponseEntity<CadastrosEfetivados> efetivaSolicitacao(@RequestBody SolicitacaoCadastro solCadastro){
		CadastrosEfetivados cad = cadastroService.efetivaSolicitacao(solCadastro);
		return ResponseEntity.ok(cad);
	}
}
