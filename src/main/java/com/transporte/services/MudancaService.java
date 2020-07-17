package com.transporte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transporte.entities.Mudanca;
import com.transporte.repositories.MudancaRepository;

@Service
public class MudancaService {
	
	@Autowired
	private MudancaRepository repository;
	
	public List<Mudanca> findAll(){
		return repository.findAll();
	}
	
	public Mudanca findById(Integer id) {
		Optional<Mudanca> obj = repository.findById(id);
		return obj.get();
	}

}
