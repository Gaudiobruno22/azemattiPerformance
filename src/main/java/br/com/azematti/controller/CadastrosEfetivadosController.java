package br.com.azematti.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.model.CadastrosEfetivados;
import br.com.azematti.service.CadastrosEfetivadosService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/cadastro")
@AllArgsConstructor
public class CadastrosEfetivadosController {

	private CadastrosEfetivadosService cadastroService;
	
	@GetMapping(value = "/todos")
	public ResponseEntity<List<CadastrosEfetivados>> buscaCadastros(){
		List<CadastrosEfetivados> list = cadastroService.buscaTodos();
		return ResponseEntity.ok(list);
	}
}
