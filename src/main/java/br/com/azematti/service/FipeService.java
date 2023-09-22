package br.com.azematti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azematti.feign.client.TabelaFipeClient;
import br.com.azematti.model.FipeMarcas;
import br.com.azematti.model.wrapper.FipeModelosWrapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FipeService {

	private TabelaFipeClient client;
	
	public List<FipeMarcas> buscaVeiculos() {
		List<FipeMarcas> busca = client.buscaTodosVeiculos();
		return busca;
	}
	
	public FipeModelosWrapper buscaTodosModelos(String marcaCodigo){
		FipeModelosWrapper list = client.buscaModelosVeiculo(marcaCodigo).getBody();
		return list;
	}
}
