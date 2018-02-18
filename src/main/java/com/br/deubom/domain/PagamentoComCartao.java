package com.br.deubom.domain;

import javax.persistence.Entity;

import com.br.deubom.domain.enums.EnumEstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroParcelas;
	
	public PagamentoComCartao() {
	} 

	public PagamentoComCartao(Integer id, EnumEstadoPagamento enumEstadoCancelado, Pedido pedido, Integer numeroParcelas) {
		super(id, enumEstadoCancelado, pedido);
		this.numeroParcelas = numeroParcelas;
	}
	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}
	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}
	
}
