package br.com.azematti.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azematti.exception.RequiredObjectException;
import br.com.azematti.model.CadastrosEfetivados;
import br.com.azematti.model.Servico;
import br.com.azematti.model.SolicitacaoCadastro;
import br.com.azematti.repository.CadastrosEfetivadosRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CadastrosEfetivadosService {

	private CadastrosEfetivadosRepository cadastroRepository;
	private SolicitacaoCadastroService solCadastroService;
	private ServicoService servicoService;
	
	private static final Logger logger = LoggerFactory.getLogger(CadastrosEfetivadosService.class);
	
	public List<CadastrosEfetivados> buscaTodos(){
	    List<CadastrosEfetivados> list = cadastroRepository.findAll();	
	    return list;
	}
	
	public void insereCadastro(CadastrosEfetivados cadastro) {
		cadastroRepository.save(cadastro);
	}
	
	public CadastrosEfetivados efetivaSolicitacao(Long solCadastroCodigo) {
		logger.info("Iniciando Efetivação do Cadastro Existente...");
		Servico servico = new Servico();
		CadastrosEfetivados cadEfetiva = new CadastrosEfetivados();
		SolicitacaoCadastro sol = solCadastroService.buscaCadastro(solCadastroCodigo);	
		if(sol.getCodigo() == null) throw new RequiredObjectException("Solicitação Cadastro não encontrada.");
		try {
			servico = servicoService.criaServico(sol);
			if(servico.getCodigo() == null) throw new RequiredObjectException("Serviço Inválido ou Vazio.");
			cadEfetiva = criaCadastro(servico, sol);
			if (cadEfetiva != null) {
				insereCadastro(cadEfetiva);
				sol.setEfetivou("S");
				solCadastroService.atualizaCadastro(sol);
			}
		}catch(Exception e) {
			logger.error("Erro ao efetivar cadastro. ERRO.: " + e.getMessage());
		}
		return null;
	}
	
	private CadastrosEfetivados criaCadastro(Servico servico, SolicitacaoCadastro solCadastro) {
		CadastrosEfetivados cadastro = new CadastrosEfetivados();
		if (servico.getCodigo() == null) throw new RequiredObjectException("Serviço está inválido ou Vazio.");
		try {
			cadastro.setDtGravacao(LocalDateTime.now());
			cadastro.setServicos(servico);
			cadastro.setUsuarioCodigo(solCadastro);
			cadastro.setVeiculo(solCadastro.getVeiculo());
		}catch(Exception e) {
			logger.error("Erro ao criar Cadastro. ERRO.: " + e.getMessage());
		}
		return cadastro;
	}
}
