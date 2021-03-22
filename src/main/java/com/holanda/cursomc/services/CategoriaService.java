package com.holanda.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.holanda.cursomc.domain.Categoria;
import com.holanda.cursomc.repositories.CategoriaRepository;
import com.holanda.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	/*
	 1º colocar anotação @Service.
	 2º Criar operação capaz de buscar uma categoria por código
	 lá do banco "buscar()". Ou seja, há uma dependencia com o objeto
	 "CategoriaRepository". Declarar dep. do obj CategoriaRepository
	 3º Para instanciar esse repositorio usa anotação @Autowired,
	 a dependencia neste caso "repo" será automaticamente instanciada
	 pelo Spring, pelo mecanismo de Injeção de Dependencia ou Inversão
	 de Controle.
	 4º Por fim, atualizar o Controlador REST para ele ser capaz de
	 buscar uma categoria.
	 
	 */
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional <Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
