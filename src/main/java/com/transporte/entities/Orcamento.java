package com.transporte.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.transporte.entities.enums.OrcamentoStatus;

@Entity
public class Orcamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Cliente clientid;
	//Preciso de um ajuda para aresolver esse dois relacioanmetos.
	private Endereco enderecoOrigem;
	private Endereco enderecoDestino;
	private String dataDesejada;
	private String dataLimite;
	private Instant dataProposta;
	private Integer orcamentoStatus ;
	
    @OneToMany
	private Set<Mudanca> mudancas = new HashSet<>();

	public Orcamento() {
		
	}

	public Orcamento(Integer id, Cliente clientid, Endereco enderecoOrigem, Endereco enderecoDestino, String dataDesejada,
			String dataLimite, Instant instant, OrcamentoStatus orcamentoStatus) {
		super();
		this.id = id;
		this.clientid = clientid;
		this.enderecoOrigem = enderecoOrigem;
		this.enderecoDestino = enderecoDestino;
		this.dataDesejada = dataDesejada;
		this.dataLimite = dataLimite;
		this.dataProposta = instant;
		setOrcamentoStatus(orcamentoStatus);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Endereco getEnderecoOrigem() {
		return enderecoOrigem;
	}

	public void setEnderecoOrigem(Endereco enderecoOrigem) {
		this.enderecoOrigem = enderecoOrigem;
	}

	public Endereco getEnderecoDestino() {
		return enderecoDestino;
	}

	public void setEnderecoDestino(Endereco enderecoDestino) {
		this.enderecoDestino = enderecoDestino;
	}

	public String getDataDesejada() {
		return dataDesejada;
	}

	public void setDataDesejada(String dataDesejada) {
		this.dataDesejada = dataDesejada;
	}

	public String getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(String dataLimite) {
		this.dataLimite = dataLimite;
	}

	public Instant getDataProposta() {
		return dataProposta;
	}

	public void setDataProposta(Instant dataProposta) {
		this.dataProposta = dataProposta;
	}

	public OrcamentoStatus getOrcamentoStatus() {
		return OrcamentoStatus.valueOf(orcamentoStatus) ;
	}

	public void setOrcamentoStatus(OrcamentoStatus orcamentoStatus) {
		this.orcamentoStatus = orcamentoStatus.getCode();
	}
	public Cliente getClientid() {
		return clientid;
	}

	public void setClientid(Cliente clientid) {
		this.clientid = clientid;
	}
	
	public Set<Mudanca> getMudanças() {
		return mudancas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientid == null) ? 0 : clientid.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orcamento other = (Orcamento) obj;
		if (clientid == null) {
			if (other.clientid != null)
				return false;
		} else if (!clientid.equals(other.clientid))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}




}
