package br.com.azematti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.azematti.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
