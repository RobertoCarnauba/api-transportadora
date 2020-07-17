package com.transporte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transporte.entities.Orcamento;
import com.transporte.repositories.OrcamentoRepository;

@Service
public class OrcamentoService {
	
	@Autowired
	private OrcamentoRepository repository;
	
	public List<Orcamento> findAll(){
		return repository.findAll();
	}
	
	public Orcamento findById(Integer id) {
		Optional<Orcamento> obj = repository.findById(id);
		return obj.get();
	}
	
	public Orcamento insert(Orcamento obj) {
		return repository.save(obj);
	}

}
