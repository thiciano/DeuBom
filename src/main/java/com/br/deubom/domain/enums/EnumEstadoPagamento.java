package com.br.deubom.domain.enums;

public enum EnumEstadoPagamento {

	PENDENTE(1, "Pendente"),
	QUITADO(2, "Quitado"),
	APROVADO(3, "Aprovado"),
	CANCELADO(4, "Cancelado");
	
	private int cod;
	private String descricao;
	
	private EnumEstadoPagamento(int cod, String descricao) {
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
	
	public static EnumEstadoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(EnumEstadoPagamento estadoPagamento : EnumEstadoPagamento.values()) {
			if(cod.equals(estadoPagamento.getCod())){
				return estadoPagamento;
			}
		}
		throw new IllegalArgumentException("Id : " + cod + "inválido!");
	}
}
