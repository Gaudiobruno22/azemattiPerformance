package br.com.azematti.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.azematti.model.Servico;
import br.com.azematti.service.ServicoService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/servico")
@AllArgsConstructor
public class ServicoController {
     
	 private ServicoService servicoService;
	 
	 private static final Logger logger = LoggerFactory.getLogger(TipoServicoController.class);
	 
	 @PostMapping(value = "/novo-servico")
	 public ResponseEntity<Void> insereServico(@RequestBody Servico servico){
			try {
				servicoService.novoServico(servico);
				return ResponseEntity.noContent().build();
			}
			catch(Exception e) {
				logger.error("{}" ,e);
				return ResponseEntity.badRequest().build();
			}
	 }
	 
	 @GetMapping(value = "/busca-todos")
	 public ResponseEntity<List<Servico>> buscaServicos(){
		    List<Servico> list = new ArrayList<>();
		 	try {
		 		list = servicoService.buscaServicos();
		 	}
		 	catch(Exception e) {
		 		logger.info("Error {}.." + e.getMessage());
		 	}
		 	return ResponseEntity.ok(list);
	 }
}
