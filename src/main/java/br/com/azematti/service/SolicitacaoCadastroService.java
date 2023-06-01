package br.com.azematti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
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
	
	public SolicitacaoCadastro buscaCadastro(Long id) {
		return repository.findById(id).orElseThrow(() -> new ServiceException("Id não encontrado!"));
	}
	
	public List<SolicitacaoCadastro> buscaCadastros(){
		return repository.findAll();
	}
	
	public SolicitacaoCadastro insereCadastro(SolicitacaoCadastro cadastro) {
		if(cadastro == null) {
			throw new RequiredObjectException();
		}
		return repository.save(cadastro);
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
	
	//Função para Atualizar as Models com base na Informação Recebida
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
