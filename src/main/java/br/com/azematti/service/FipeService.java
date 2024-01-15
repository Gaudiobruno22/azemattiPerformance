package br.com.azematti.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azematti.exception.ResourceNotFoundException;
import br.com.azematti.feign.client.TabelaFipeClient;
import br.com.azematti.fipe.request.FipeAnosRequest;
import br.com.azematti.fipe.request.FipeDadosRequest;
import br.com.azematti.fipe.request.FipeModelosRequest;
import br.com.azematti.fipe.response.FipeAnosResponse;
import br.com.azematti.fipe.response.FipeDadosResponse;
import br.com.azematti.fipe.response.FipeMarcasResponse;
import br.com.azematti.model.wrapper.FipeModelosWrapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FipeService {

	private TabelaFipeClient client;

	private static final Logger logger = LoggerFactory.getLogger(FipeService.class);
	
	public List<FipeMarcasResponse> buscaVeiculos() {
		List<FipeMarcasResponse> busca = client.buscaTodosVeiculos();
		return busca;
	}
	
	public FipeModelosWrapper buscaTodosModelos(String marcaCodigo){
		FipeModelosRequest request = new FipeModelosRequest();
		FipeModelosWrapper list = new FipeModelosWrapper();
		try {
			request.setMarcaCodigo(marcaCodigo);
			list = client.buscaModelosVeiculo(request.getMarcaCodigo()).getBody();
		}catch(Exception e) {
			logger.error("Erro ao Buscar Modelos FIPE. ERRO.: " + e.getMessage());
		}
		return list;
	}
	
	public List<FipeAnosResponse> buscaAnoVeiculo(String marcaCodigo, String modeloCodigo){
		FipeAnosRequest request = new FipeAnosRequest();
		List<FipeAnosResponse> response = new ArrayList<>();
		try {
			request.setMarcaCodigo(marcaCodigo);
			request.setModeloCodigo(modeloCodigo);
			response = client.buscaAnoModelo(request.getMarcaCodigo(), request.getModeloCodigo());	
		}catch(Exception e) {
			logger.error("Erro ao Buscar ano veículo FIPE. ERRO.: " + e.getMessage());
		}
		return response;
	}
	
	public FipeDadosResponse retornaValorFipe(String marcaCodigo, String modeloCodigo, String anoCodigo) {
		FipeDadosRequest request = new FipeDadosRequest();
		FipeModelosWrapper modelos = new FipeModelosWrapper();
		List<FipeAnosResponse> anos = new ArrayList<>();
		FipeDadosResponse response = new FipeDadosResponse();
		try {
			request.setMarcaCodigo(marcaCodigo);
			request.setModeloCodigo(modeloCodigo);
			request.setAnoCodigo(anoCodigo);
			
			logger.info("COMO ESTÁ VINDO O ANO " + request.getAnoCodigo());
			if(request.getMarcaCodigo() != null) {
				modelos = buscaTodosModelos(request.getMarcaCodigo());
			}
			if(modelos.equals(null)) {
				throw new ResourceNotFoundException("Marca não encontrada na API de Marcas.");
			}else {
				anos = buscaAnoVeiculo(request.getMarcaCodigo(), request.getModeloCodigo());
				if(anos.isEmpty()) {
					throw new ResourceNotFoundException("Ano não encontrado na API FIPE.");
				}
				response = client.consultaValorFipe(request.getMarcaCodigo(), request.getModeloCodigo(), request.getAnoCodigo());
			}
			
		}catch(Exception e) {
			System.out.println("Erro ao Buscar FIPE: " + e.getMessage());
		}	
		return response;
	}
}
