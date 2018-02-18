package com.br.deubom.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.br.deubom.domain.enums.EnumTipoPessoa;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //Observar qual a base para usar o GenerationType correto.
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipoPessoa;
	
	
	@OneToMany(mappedBy="cliente")
	private List<Endereco> enderecos = new ArrayList<Endereco>();

	@ElementCollection
	@CollectionTable(name="TELEFONE")
	private Set<String> telefones = new HashSet<String>();
	
	public Cliente() {
		super();
	}
	
	public Cliente(Integer id, String nome, String email, String cpfOuCnpj, EnumTipoPessoa tipoPessoa) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipoPessoa = tipoPessoa.getCod();
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	//Controle do enum dentro da classe de dominio como inteiro/
	public EnumTipoPessoa getTipoPessoa() {
		return EnumTipoPessoa.toEnum(tipoPessoa);
	}

	public void setTipoPessoa(EnumTipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
}
