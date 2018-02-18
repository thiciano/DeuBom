package com.br.deubom;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.br.deubom.domain.Categoria;
import com.br.deubom.domain.Cidade;
import com.br.deubom.domain.Cliente;
import com.br.deubom.domain.Endereco;
import com.br.deubom.domain.Estado;
import com.br.deubom.domain.Produto;
import com.br.deubom.domain.enums.EnumTipoPessoa;
import com.br.deubom.repositories.CategoriaRepository;
import com.br.deubom.repositories.CidadeRepository;
import com.br.deubom.repositories.ClienteRepository;
import com.br.deubom.repositories.EnderecoRepository;
import com.br.deubom.repositories.EstadoRepository;
import com.br.deubom.repositories.ProdutoRepository;

@SpringBootApplication
public class DeuBomApplication implements CommandLineRunner {

	@Autowired
	public CategoriaRepository categoriaRepository;

	@Autowired
	public ClienteRepository clienteRepository;
	
	@Autowired
	public EnderecoRepository enderecoRepository;

	@Autowired
	public ProdutoRepository produtoRepository;
	
	@Autowired
	public EstadoRepository estadoRepository;
	
	@Autowired
	public CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DeuBomApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null, "Escritório");
		Categoria cat2 = new Categoria(null, "Informática");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 600.00);
		Produto p3 = new Produto(null, "Mouse", 60.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));

		produtoRepository.save(Arrays.asList(p1,p2,p3));
		
		
		Estado est1 = new Estado(null, "Distrito Federal"); 
		Estado est2 = new Estado(null, "Minas Gerais"); 

		Cidade cid1 = new Cidade(null, "Brasília", est1);
		Cidade cid2 = new Cidade(null, "uberlandia", est2);
		Cidade cid3 = new Cidade(null, "Araguari", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		
		cidadeRepository.save(Arrays.asList(cid1, cid2, cid3));

		
		Cliente  cli1 = new Cliente(null, "Thiciano Ferreira Fagundes", "thiciano@bol.com.br", "84689005168", EnumTipoPessoa.PESSOA_FISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("999921999","33434243"));

		Cliente  cli2 = new Cliente(null, "Mel Ferreira Fagundes", "mel@bol.com.br", "84689005178", EnumTipoPessoa.PESSOA_JURIDICA);
		
		cli2.getTelefones().addAll(Arrays.asList("99955555","34564000"));

		Endereco e1 = new Endereco(null, "Lougradouro", "numero", "bairro", "complemento", "CEp", cli1, cid1);
		Endereco e2 = new Endereco(null, "Lougradouro2", "numero2", "bairro2", "complemento222", "2222222", cli1, cid1);
				
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		cli2.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1, cli2));
		enderecoRepository.save(Arrays.asList(e1, e2));
		
	}
	
}

 