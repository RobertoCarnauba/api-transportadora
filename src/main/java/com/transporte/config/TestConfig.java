package com.transporte.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.transporte.entities.Trasportadora;
import com.transporte.repositories.TraspotadoraRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	@Autowired
	private TraspotadoraRepository repository;
	
    @Override
	public void run(String... args) throws Exception {
		Trasportadora t1 = new Trasportadora(null, "Super FastTrans", "52221710000145", "rua um 132", "email@email.com", "password123", "11961063734");
		Trasportadora t2 = new Trasportadora(null, "Trans SameThings", "52221710000145", "rua um 132", "email@email.com", "password123", "11961063734");
		
		
		repository.saveAll(Arrays.asList(t1, t2));
	}
	
	
}
