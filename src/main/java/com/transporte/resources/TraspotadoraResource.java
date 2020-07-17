package com.transporte.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.transporte.entities.Trasportadora;
import com.transporte.services.TrasportadoraService;

@RestController
@RequestMapping("/transportadoras")
public class TraspotadoraResource {
	@Autowired
	private TrasportadoraService service; 
	
	@GetMapping
	public ResponseEntity<List<Trasportadora>> finAll(){
		List<Trasportadora> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Trasportadora> findById(@PathVariable Integer id){
		Trasportadora obj = service.findById(id); 
		return ResponseEntity.ok().body(obj);	
	}
	
	@PostMapping
	public ResponseEntity<Trasportadora> insert(@RequestBody Trasportadora obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws Exception{
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Trasportadora> update(@PathVariable Integer id,@RequestBody Trasportadora obj) throws Exception {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		
	}

}
