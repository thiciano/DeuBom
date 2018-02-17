package com.br.deubom.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.deubom.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1, "Eletrônicos");
		Categoria cat2 = new Categoria(2, "Moveis");
		
		List<Categoria> categosrias = new ArrayList<Categoria>();
		categosrias.add(cat1);
		categosrias.add(cat2);
		
		
		return categosrias;
	}
	
}
