package br.com.teleset.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teleset.domain.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
