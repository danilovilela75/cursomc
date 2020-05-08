package br.com.teleset.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.teleset.domain.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
