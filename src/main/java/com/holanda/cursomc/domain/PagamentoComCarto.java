package com.holanda.cursomc.domain;

import javax.persistence.Entity;

import com.holanda.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCarto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer numeroDeParcelas;
	
	public PagamentoComCarto() {
	}

	public PagamentoComCarto(Integer id, EstadoPagamento estado, Pedido pedido, int numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}
	
	
	
}
