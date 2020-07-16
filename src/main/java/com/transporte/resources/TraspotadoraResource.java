package com.transporte.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transporte.entities.Trasportadora;
import com.transporte.services.TrasportadoraService;

@RestController
@RequestMapping("/Trasportadora")
public class TraspotadoraResource {
	@Autowired
	private TrasportadoraService service; 
	
	@GetMapping
	public ResponseEntity<List<Trasportadora>> finAll(){
		List<Trasportadora> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trasportadora> findById(@PathVariable String id){
		Trasportadora obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);
		
	}

}
