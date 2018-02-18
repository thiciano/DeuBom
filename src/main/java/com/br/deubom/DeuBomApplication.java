package com.br.deubom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.deubom.domain.Categoria;
import com.br.deubom.repositories.CategoriaRepository;

@SpringBootApplication
public class DeuBomApplication implements CommandLineRunner {

	@Autowired
	public CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DeuBomApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(1, "Escritório");
		Categoria cat2 = new Categoria(2, "Informática");
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
	}
	
}
