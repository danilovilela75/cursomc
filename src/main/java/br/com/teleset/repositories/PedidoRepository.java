package br.com.teleset.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teleset.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
