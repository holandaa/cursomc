package com.holanda.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.holanda.cursomc.domain.Categoria;

@RestController //classe rest que responde pelo endpoint
@RequestMapping(value = "/categorias") //aqui é endpoint
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		
		/*obs.: o List é uma interface, então procuro
		  uma classe que implementa a interface
		  para instanciar a lista
		 */
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		return lista;
	}
	
}
