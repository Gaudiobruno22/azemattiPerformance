package br.com.azematti.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azematti.feign.client.TabelaFipeClient;
import br.com.azematti.fipe.response.FipeAnosResponse;
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
		FipeModelosWrapper list = client.buscaModelosVeiculo(marcaCodigo).getBody();
		return list;
	}
	
	public List<FipeAnosResponse> buscaAnoVeiculo(String marcaCodigo, String modeloCodigo){
		List<FipeAnosResponse> response = client.buscaAnoModelo(marcaCodigo, modeloCodigo);
		return response;
	}
	
//	public FipeDados retornaValorFipe(String marcaCodigo, String modeloCodigo, String anoCodigo) {
//		FipeModelosWrapper modelos = new FipeModelosWrapper();
//		List<FipeAnos> anos = new ArrayList<>();
//		FipeDados fipe = new FipeDados();
//		try {
//			if(!marcaCodigo.isEmpty()) {
//				modelos = buscaTodosModelos(marcaCodigo);
//				logger.info("Testando Logger : " + marcaCodigo);
//			}
//			if(modelos.equals(null)) {
//				throw new ResourceNotFoundException("Marca não encontrada na API de Marcas.");
//			}else {
//				anos = buscaAnoVeiculo(marcaCodigo, modeloCodigo);
//				if(anos.isEmpty()) {
//					throw new ResourceNotFoundException("Ano não encontrado na API FIPE.");
//				}
//			}
//			//Se todas Validações ok, Vou buscar o Valor Fipe.
//			fipe = client.consultaValorFipe(marcaCodigo, modeloCodigo, anoCodigo);
//		}catch(Exception e) {
//			System.out.println("Erro ao Buscar FIPE: " + e.getMessage());
//		}	
//		return fipe;
//	}
}
