package com.transporte.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.transporte.entities.Cliente;
import com.transporte.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
	
	public Cliente insert(Cliente obj) {
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
	
	public Cliente update(Integer id, Cliente obj) throws Exception {
		try {
			Cliente entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch(EntityNotFoundException e) {
			throw new Exception(e);
		}
		
	}

	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());
	}
	
}
