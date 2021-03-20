package com.holanda.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.holanda.cursomc.domain.ItemPedido;

@Repository
public interface ItemPedidoRepositoryRepository extends JpaRepository<ItemPedido, Integer>{

}
