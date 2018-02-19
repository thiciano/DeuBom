package com.br.deubom.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.deubom.domain.Pedido;
import com.br.deubom.repositories.PedidoRepository;
import com.br.deubom.resources.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	public PedidoRepository repo;
	
	public Pedido find(Integer id) {
		
		Pedido obj = repo.findOne(id);
		if(obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id : " + id + 
					", tipo: " + Pedido.class.getName());
		}
		return obj;
	}
}
