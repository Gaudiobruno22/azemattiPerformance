package br.com.azematti.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.exception.ResourceNotFoundException;
import br.com.azematti.model.SolicitacaoCadastro;
import br.com.azematti.repository.SolicitacaoCadastroRepository;
import br.com.azematti.service.SolicitacaoCadastroService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cadastro")
public class SolicitacaoCadastroController {
	
	private SolicitacaoCadastroService service;
	
	private SolicitacaoCadastroRepository repository;
	
	private static final Logger logger = LoggerFactory.getLogger(SolicitacaoCadastroController.class);

	@GetMapping(value = "/consulta/{codigo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SolicitacaoCadastro> encontraCadastro(@PathVariable Long codigo){
		SolicitacaoCadastro model = service.buscaCadastro(codigo);
		return ResponseEntity.ok().body(model);
	}
	
	@PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseStatus(HttpStatus.CREATED)
	public SolicitacaoCadastro insereCadastro(@RequestBody SolicitacaoCadastro cadastro){
		return service.insereCadastro(cadastro);
	}
	
	@PutMapping(value = "/atualiza/{id}")
	public ResponseEntity<SolicitacaoCadastro> atualizaCadastro(@PathVariable Long id, @RequestBody SolicitacaoCadastro cadastro){
		cadastro.setCodigo(id);
		if(!repository.existsById(cadastro.getCodigo())) {
			throw new ResourceNotFoundException();
		}
		else {
			service.atualizaCadastro(cadastro);
			logger.info("Cadastro está atualizado? " + cadastro.toString());
		}
		return ResponseEntity.ok(cadastro);
	}
	
	@DeleteMapping(value = "/deletar/{id}")
	public ResponseEntity<Void> deleteCadastro(@PathVariable Long id){
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build(); 
		}
		service.excluiCadastro(id);
		return ResponseEntity.noContent().build();
	}
}
