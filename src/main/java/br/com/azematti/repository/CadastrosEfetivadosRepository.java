package br.com.azematti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.azematti.model.CadastrosEfetivados;

@Repository
public interface CadastrosEfetivadosRepository extends JpaRepository<CadastrosEfetivados, Long>{

}
