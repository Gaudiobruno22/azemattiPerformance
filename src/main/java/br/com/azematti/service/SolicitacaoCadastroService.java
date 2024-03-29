package br.com.azematti.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.azematti.exception.RequiredObjectException;
import br.com.azematti.exception.ResourceNotFoundException;
import br.com.azematti.exception.ServiceException;
import br.com.azematti.model.SolicitacaoCadastro;
import br.com.azematti.model.dto.SolicitacaoCadastroDTO;
import br.com.azematti.repository.SolicitacaoCadastroRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SolicitacaoCadastroService {

	private SolicitacaoCadastroRepository repository;
	
	private ModelMapper modelMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(SolicitacaoCadastroService.class);
	
	public SolicitacaoCadastro buscaCadastro(Long id) {
		return repository.findById(id).orElseThrow(() -> new ServiceException("Id não encontrado!"));
	}
	
	public Page<SolicitacaoCadastroDTO> buscaCadastros(Pageable pageable){
		var solicitacaoPage = repository.findAll(pageable);
		var solicitacaoDto = solicitacaoPage.map(x -> this.toDTO(x));		
		return solicitacaoDto;
	}
	
	public SolicitacaoCadastro buscaSolicitacaoNaoEfetivada(Long codigo) {
		SolicitacaoCadastro sol = repository.findByCodigo(codigo);
		try {
			if(sol.getCodigo() == null) {
				throw new ResourceNotFoundException("Cadastro não Encontrado.");
			}
		}catch (Exception e) {
			logger.error("Cadastro Não Encontrado.");
		}
		return sol;
	}
	
	public SolicitacaoCadastro insereCadastro(SolicitacaoCadastro cadastro) {
		if(cadastro == null) {
			throw new RequiredObjectException();
		}
		cadastro.setCodigo(cadastro.getCodigo());
		repository.save(cadastro);
		toDTO(cadastro);
		return cadastro;
	}
	
	public SolicitacaoCadastro atualizaCadastro(SolicitacaoCadastro cadastro) {
		if(cadastro == null) {
			throw new RequiredObjectException();
		}
		SolicitacaoCadastro cad = repository.findByCodigo(cadastro.getCodigo());
		atualizarDados(cad, cadastro);
		return repository.save(cadastro);
	}
	
	public void excluiCadastro(Long id) {
		SolicitacaoCadastro cad = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Impossívele Excluir. Id não encontrado."));
		repository.delete(cad);
	}
	
	private void atualizarDados(SolicitacaoCadastro antigo, SolicitacaoCadastro novo) {
		novo = repository.findByCodigo(antigo.getCodigo());
		
		antigo.setNome(novo.getNome());
		antigo.setEstado(novo.getEstado());
		antigo.setCidade(novo.getCidade());
		antigo.setTelefone(novo.getTelefone());
		antigo.setVeiculo(novo.getVeiculo());
		antigo.setServico(novo.getServico());
	}
	
	public SolicitacaoCadastroDTO toDTO(SolicitacaoCadastro cadastro) {
		return modelMapper.map(cadastro, SolicitacaoCadastroDTO.class);
	}
	
}
