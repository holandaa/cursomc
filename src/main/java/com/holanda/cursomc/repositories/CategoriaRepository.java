package com.holanda.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.holanda.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	/*
	 CategoriaRepository
	 
	 Classe capaz de acessar o banco de dados e 
	 realizar ações como busca, salvar, deletar 
	 os dados da tabela 'Categoria'
	 
	 1º colocar anotação @Repository
	 2º extender JpaRespository passando o objeto tipo Categoria
	 */
	
	
}
