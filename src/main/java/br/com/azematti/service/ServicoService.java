package br.com.azematti.service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azematti.exception.RequiredObjectException;
import br.com.azematti.model.Servico;
import br.com.azematti.model.SolicitacaoCadastro;
import br.com.azematti.model.TipoServico;
import br.com.azematti.repository.ServicoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ServicoService {

	private static final Logger logger = LoggerFactory.getLogger(ServicoService.class);
	
	private ServicoRepository repository;
	private TipoServicoService tipoServico;
	
	
	public List<Servico> buscaServicos(){
		return repository.findAll();
	}
	
	public Servico salvaServico(Servico servico) {
		return repository.save(servico);
	}
	
	public Servico criaServico(SolicitacaoCadastro cadastro) {
		logger.info("Iniciando Criação do Serviço...");
		Servico servico = new Servico();
		if(cadastro.getCodigo() == null) throw new RequiredObjectException("Cadastro não encontrado para Criar o Serviço.");
		try {
			servico.setCpf(cadastro.getCpf());
			servico.setDescricao(cadastro.getServico());
			servico.setDtGravacao(LocalDateTime.now());
			servico.setFinalizado("N".toUpperCase());
			servico.setPago("N".toUpperCase());
			buscaTipoServico(cadastro, servico);
			servico.setUsuarioCodigo(cadastro);
			salvaServico(servico);
		}catch(Exception e) {
			logger.error("Erro ao criar Serviço. ERRO.: " + e.getMessage());
		}
		return servico;
	}
	
	public Servico buscaTipoServico(SolicitacaoCadastro solCadastro, Servico servico) {
		logger.info("Iniciando verificação do Tipo de Serviço...");
		TipoServico tpServico = new TipoServico();
		if (solCadastro.getCodigo() == null) throw new RequiredObjectException("Cadastro não encontrado para buscar o Tipo de Serviço.");
		try {
			if (solCadastro.getServico().equalsIgnoreCase("Stage 01")) {
				tpServico = tipoServico.buscaTpServico(1L);
				servico.setTpServico(tpServico);
				servico.setValor(tpServico.getValorServico());
			}else if (solCadastro.getServico().equalsIgnoreCase("Stage 02")) {
				tpServico = tipoServico.buscaTpServico(2L);
				servico.setTpServico(tpServico);
				servico.setValor(tpServico.getValorServico());
			}else {
				tpServico = tipoServico.buscaTpServico(3L);
				servico.setTpServico(tpServico);
				servico.setValor(tpServico.getValorServico());
			}
			return servico;
		}catch(Exception e) {
			logger.error("Erro ao associar Tipo de Serviço. ERRO.: " + e.getMessage());
		}
		return servico;
	}
}
