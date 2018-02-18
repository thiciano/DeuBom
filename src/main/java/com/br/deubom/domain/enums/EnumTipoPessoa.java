package com.br.deubom.domain.enums;

public enum EnumTipoPessoa {

	PESSOA_FISICA(1,"Pessoa Física"),
	PESSOA_JURIDICA(2, "Pessoa Jurídica");
	
	private int cod;
	private String descricao;
	
	private EnumTipoPessoa(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static EnumTipoPessoa toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EnumTipoPessoa tipoPessoa : EnumTipoPessoa.values()) {
			if(cod.equals(tipoPessoa.getCod())){
				return tipoPessoa;
			}
		}
		throw new IllegalArgumentException("Id : " + cod + "inválido!");
	}
	
}
