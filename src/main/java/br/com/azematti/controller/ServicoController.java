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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/servico")
@AllArgsConstructor
@Api(value = "EndPoint Dos Serviços que estão sendo Executados.", description = "Quando um Serviço é efetivado, Ele irá retornar qual o Tipo de Serviço, com demais Informações.", 
	 tags = "ServicoController")
public class ServicoController {
     
	 private ServicoService servicoService;
	 
	 private static final Logger logger = LoggerFactory.getLogger(TipoServicoController.class);
	 
//	 @ApiOperation(value = "EndPoint para Inserir os dados de um Novo Serviço.")
//	 @PostMapping(value = "/novo-servico")
//	 public ResponseEntity<Void> insereServico(@RequestBody Servico servico){
//			try {
//				servicoService.novoServico(servico);
//				return ResponseEntity.noContent().build();
//			}
//			catch(Exception e) {
//				logger.error("{}" ,e);
//				return ResponseEntity.badRequest().build();
//			}
//	 }
	 
	 @ApiOperation(value = "Busca todos Serviços Registrados.")
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
