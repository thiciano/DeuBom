package com.br.deubom.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.br.deubom.domain.enums.EnumEstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVencimento; 
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPagamento; 
	
	private EnumEstadoPagamento enumEstadoCancelado;

	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EnumEstadoPagamento enumEstadoCancelado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, enumEstadoCancelado, pedido);
		this.dataVencimento = dataVencimento; 
		this.dataPagamento = dataPagamento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public EnumEstadoPagamento getEnumEstadoCancelado() {
		return enumEstadoCancelado;
	}
	public void setEnumEstadoCancelado(EnumEstadoPagamento enumEstadoCancelado) {
		this.enumEstadoCancelado = enumEstadoCancelado;
	}
}
