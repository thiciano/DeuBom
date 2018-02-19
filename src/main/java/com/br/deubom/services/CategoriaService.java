package com.br.deubom.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.br.deubom.domain.Categoria;
import com.br.deubom.repositories.CategoriaRepository;
import com.br.deubom.services.exception.DataIntegrityException;
import com.br.deubom.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository repo;
	
	public Categoria find(Integer id) {		
		Categoria obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id : " + id + 
					", tipo: " + Categoria.class.getName());
		}
		return obj;
	}

	public List<Categoria> findAll() {
		List<Categoria> lista = repo.findAll();
		if(lista == null) {
			throw new ObjectNotFoundException("Nenhum objeto encontrado! Tipo: " + Categoria.class.getName());
		}
		return lista;
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
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
			repo.delete(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir Categoria(s) que possui(em) Produto(s) vinculados");
		}
	}
}
