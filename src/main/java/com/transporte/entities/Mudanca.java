package com.transporte.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.transporte.entities.enums.MudancaStatus;

@Entity
public class Mudanca implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer mudancaStatus;
	@ManyToMany(mappedBy = "mudancas")
	private Set<Orcamento> orcamentos = new HashSet<>();
	
	public Mudanca() {
		
	}

	public Mudanca(Integer id,Orcamento orcamento, MudancaStatus mudancaStatus) {
		super();
		this.id = id;
		setMudancaStatus(mudancaStatus);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MudancaStatus getMudancaStatus() {
		return MudancaStatus.valueOf(mudancaStatus) ;
	}

	public void setMudancaStatus(MudancaStatus mudancaStatus) {
		this.mudancaStatus = mudancaStatus.getCode();
	}
	
	public Set<Orcamento> getOrcamento() {
		return orcamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Mudanca other = (Mudanca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	
}
