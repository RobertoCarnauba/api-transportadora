package com.transporte.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transporte.entities.Trasportadora;
import com.transporte.repositories.TraspotadoraRepository;

@Service
public class TrasportadoraService {
	
	@Autowired
	private TraspotadoraRepository repository;
	
	public List<Trasportadora> findAll(){
		return repository.findAll();
	}
	
	public Trasportadora findById(String id) {
		Optional<Trasportadora> obj = repository.findById(id);
		return obj.get();
	}

}
