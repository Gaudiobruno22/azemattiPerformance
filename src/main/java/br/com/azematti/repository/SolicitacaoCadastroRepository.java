package br.com.azematti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.azematti.model.SolicitacaoCadastro;

@Repository
public interface SolicitacaoCadastroRepository extends JpaRepository<SolicitacaoCadastro, Long>{

	SolicitacaoCadastro findByCodigo(Long codigo);
}
