package br.com.teleset.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sun.xml.bind.v2.model.core.ID;

import br.com.teleset.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
