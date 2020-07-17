package com.transporte.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transporte.entities.Mudanca;
import com.transporte.services.MudancaService;

@RestController
@RequestMapping("/mudanca")
public class MudancaResource {
	@Autowired
	private MudancaService service; 
	
	@GetMapping
	public ResponseEntity<List<Mudanca>> finAll(){
		List<Mudanca> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Mudanca> findById(@PathVariable Integer id){
		Mudanca obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);
		
	}

}
