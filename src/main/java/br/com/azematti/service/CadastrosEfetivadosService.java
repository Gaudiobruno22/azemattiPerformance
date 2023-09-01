package br.com.azematti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azematti.model.CadastrosEfetivados;
import br.com.azematti.repository.CadastrosEfetivadosRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CadastrosEfetivadosService {

	private CadastrosEfetivadosRepository cadastroRepository;
	private SolicitacaoCadastroService solCadastroService;
	
	public List<CadastrosEfetivados> buscaTodos(){
	    List<CadastrosEfetivados> list = cadastroRepository.findAll();	
	    return list;
	}
	
	public void insereCadastro(CadastrosEfetivados cadastro) {
		cadastroRepository.save(cadastro);
	}
}
