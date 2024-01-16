package br.com.azematti.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.azematti.model.SolicitacaoCadastro;
import br.com.azematti.model.dto.SolicitacaoCadastroDTO;

@Repository
public interface SolicitacaoCadastroRepository extends JpaRepository<SolicitacaoCadastro, Long>{

	SolicitacaoCadastro findByCodigo(Long codigo);

	
}
