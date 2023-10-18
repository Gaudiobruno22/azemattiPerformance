package br.com.azematti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.azematti.exception.RequiredObjectException;
import br.com.azematti.model.CadastrosEfetivados;
import br.com.azematti.model.SolicitacaoCadastro;
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
	
	public CadastrosEfetivados efetivaSolicitacao(SolicitacaoCadastro solCadastro) {
		SolicitacaoCadastro sol = solCadastroService.buscaCadastro(solCadastro.getCodigo());
		if(sol.equals(sol) == true) throw new RequiredObjectException("Solicitação não possui registros.");
		
		try {
			
		}catch(Exception e) {
			
		}
		return null;
	}
}
