package com.br.deubom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.deubom.domain.Cliente;
import com.br.deubom.repositories.ClienteRepository;
import com.br.deubom.resources.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	public ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		
		Cliente obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id : " + id + 
					", tipo: " + Cliente.class.getName());
		}
		return obj;
	}
}
