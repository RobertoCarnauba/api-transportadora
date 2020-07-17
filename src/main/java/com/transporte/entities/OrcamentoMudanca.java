package com.transporte.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrcamentoMudanca implements Serializable {
	private static final long serialVersionUID = 1L;
	private Orcamento idOrcamento;
	private String dataProposta;
	
	public OrcamentoMudanca() {
		
	}

	public OrcamentoMudanca(Orcamento idOrcamento, String dataProposta) {
		super();
		this.idOrcamento = idOrcamento;
		this.dataProposta = dataProposta;
	}

	public Orcamento getIdOrcamento() {
		return idOrcamento;
	}

	public void setIdOrcamento(Orcamento idOrcamento) {
		this.idOrcamento = idOrcamento;
	}

	public String getDataProposta() {
		return dataProposta;
	}

	public void setDataProposta(String dataProposta) {
		this.dataProposta = dataProposta;
	}

	
}
