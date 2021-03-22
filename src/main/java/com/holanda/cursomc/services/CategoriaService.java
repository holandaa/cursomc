package com.holanda.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.holanda.cursomc.domain.Categoria;
import com.holanda.cursomc.dto.CategoriaDTO;
import com.holanda.cursomc.repositories.CategoriaRepository;
import com.holanda.cursomc.services.exceptions.DataIntegrityException;
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
	
	public Categoria find(Integer id) {
		Optional <Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos.");
		}
	}
	
	public List<Categoria> findAll() {
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
}
