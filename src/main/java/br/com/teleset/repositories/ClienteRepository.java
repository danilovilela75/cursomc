package br.com.teleset.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teleset.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
