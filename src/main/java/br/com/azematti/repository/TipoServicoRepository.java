package br.com.azematti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.azematti.model.TipoServico;

@Repository
public interface TipoServicoRepository extends JpaRepository<TipoServico, Long>{

}
