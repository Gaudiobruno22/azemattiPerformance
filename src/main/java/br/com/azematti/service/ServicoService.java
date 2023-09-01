package br.com.azematti.service;

import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import br.com.azematti.exception.RequiredObjectException;
import br.com.azematti.model.CadastrosEfetivados;
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
	private SolicitacaoCadastroService usuarioService;
	private CadastrosEfetivadosService cadastroEfetivadoService;
	
	
	public List<Servico> buscaServicos(){
		return repository.findAll();
	}
	
	public void novoServico (Servico servico) {
		if(servico.equals(null)) {
			throw new RequiredObjectException("Valores Nulos ou Inválidos.");
		}
		TipoServico tpServico = tipoServico.buscaTpServico(servico.getTpServico().getCodigo());
		SolicitacaoCadastro usuCad = usuarioService.buscaCadastro(servico.getUsuarioCodigo().getCodigo());
		try {
			servico.setTpServico(tpServico);
			servico.setUsuarioCodigo(usuCad);
			servico.setDtGravacao(Calendar.getInstance());
			repository.save(servico);
			
			CadastrosEfetivados novoCadastro = new CadastrosEfetivados();
			novoCadastro.setServicos(servico);
			novoCadastro.setDtGravacao(servico.getDtGravacao());
			novoCadastro.setUsuarioCodigo(usuCad);
			novoCadastro.setVeiculo(usuCad.getVeiculo());
			cadastroEfetivadoService.insereCadastro(novoCadastro);
		}catch(Exception e) {
			logger.info("Error {}..." + e.getMessage());
		}	
	}
	
}
