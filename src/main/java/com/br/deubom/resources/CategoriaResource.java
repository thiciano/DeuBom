package com.br.deubom.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.deubom.domain.Categoria;
import com.br.deubom.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {

	@Autowired 
	public CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		
		Categoria cat1 = new Categoria(1, "Eletrônicos");
		Categoria cat2 = new Categoria(2, "Moveis");
		
		List<Categoria> categosrias = new ArrayList<Categoria>();
		categosrias.add(cat1);
		categosrias.add(cat2);
		
		return ResponseEntity.ok().body(obj) ;
	}
	
}
