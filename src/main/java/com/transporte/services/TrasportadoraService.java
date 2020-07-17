package com.transporte.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
	
	public Trasportadora findById(Integer id) {
		Optional<Trasportadora> obj = repository.findById(id);
		return obj.get();
	}

	public Trasportadora insert(Trasportadora obj) {
		return repository.save(obj);
	}
	
	public void delete(Integer id) throws Exception {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new Exception(e);
		} catch (DataIntegrityViolationException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public Trasportadora update(Integer id, Trasportadora obj) throws Exception {
		try {
			Trasportadora entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new Exception(e);
		}
		
	}

	private void updateData(Trasportadora entity, Trasportadora obj) {
		entity.setName(obj.getName());
		entity.setEndereco(obj.getEndereco());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		entity.setPhone(obj.getPhone());
	}

}
