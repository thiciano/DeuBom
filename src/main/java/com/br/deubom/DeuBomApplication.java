package com.br.deubom;

import java.text.SimpleDateFormat;
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
import com.br.deubom.domain.ItemPedido;
import com.br.deubom.domain.Pagamento;
import com.br.deubom.domain.PagamentoComBoleto;
import com.br.deubom.domain.PagamentoComCartao;
import com.br.deubom.domain.Pedido;
import com.br.deubom.domain.Produto;
import com.br.deubom.domain.enums.EnumEstadoPagamento;
import com.br.deubom.domain.enums.EnumTipoPessoa;
import com.br.deubom.repositories.CategoriaRepository;
import com.br.deubom.repositories.CidadeRepository;
import com.br.deubom.repositories.ClienteRepository;
import com.br.deubom.repositories.EnderecoRepository;
import com.br.deubom.repositories.EstadoRepository;
import com.br.deubom.repositories.ItemPedidoRepository;
import com.br.deubom.repositories.PagamentoRepository;
import com.br.deubom.repositories.PedidoRepository;
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
	
	@Autowired
	public PedidoRepository pedidoRepository;
	
	@Autowired
	public PagamentoRepository pagamentoRepository;
	
	@Autowired
	public ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DeuBomApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Categoria cat1 = new Categoria(null, "Escritório");
		Categoria cat2 = new Categoria(null, "Informática");
		Categoria cat3 = new Categoria(null, "Cama, Mesa e Banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 600.00);
		Produto p3 = new Produto(null, "Mouse", 60.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7));

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
		
		SimpleDateFormat	 sdf = new SimpleDateFormat("dd/MM/YYYY hh:mm");
		
		Pedido ped1  = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2  = new Pedido(null, sdf.parse("10/01/2018 17:32"), cli2, e2);
		
		Pagamento pagto1 = new PagamentoComBoleto(null, EnumEstadoPagamento.QUITADO, ped1, sdf.parse("30/09/2017 10:32"), sdf.parse("30/09/2017 10:32"));
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComCartao(null, EnumEstadoPagamento.PENDENTE, ped2, 10);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.save(Arrays.asList(ped1, ped2));
		pagamentoRepository.save(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 1, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.save(Arrays.asList(ip1,ip2,ip3));
		
		
		
	}
	
}

 