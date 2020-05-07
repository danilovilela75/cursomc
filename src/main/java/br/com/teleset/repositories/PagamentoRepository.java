package br.com.teleset.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teleset.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
