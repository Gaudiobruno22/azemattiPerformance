package br.com.azematti.service;

import org.springframework.stereotype.Service;

import br.com.azematti.exception.RequiredObjectException;
import br.com.azematti.exception.ResourceNotFoundException;
import br.com.azematti.model.TipoServico;
import br.com.azematti.repository.TipoServicoRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TipoServicoService {

	private TipoServicoRepository tpRepository;
	
	public void insereTipoServico(TipoServico tpServico) {
		if(tpServico == null) {
			throw new RequiredObjectException();
		}
		
	    tpRepository.save(tpServico);
	}
	
	public TipoServico buscaTpServico (Long id) {
		return tpRepository.findById(id)
					.orElseThrow(() ->  new ResourceNotFoundException("Id Não Encontrado."));
	}
}
