package com.transporte.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.transporte.entities.Cliente;
import com.transporte.entities.Mudanca;
import com.transporte.entities.Orcamento;
import com.transporte.entities.Trasportadora;
import com.transporte.entities.enums.MudancaStatus;
import com.transporte.entities.enums.OrcamentoStatus;
import com.transporte.repositories.ClienteRepository;
import com.transporte.repositories.MudancaRepository;
import com.transporte.repositories.OrcamentoRepository;
import com.transporte.repositories.TraspotadoraRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	
	@Autowired
	private TraspotadoraRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OrcamentoRepository orcamentoRepository;
	
	@Autowired
	private MudancaRepository mudancaRepository;
	
    @Override
	public void run(String... args) throws Exception {
    	Trasportadora t1 = new Trasportadora(null, "Super FastTrans", "52221710000145", "rua um 132", "email@email.com", "password123", "11961063734");
		Trasportadora t2 = new Trasportadora(null, "Trans SameThings", "52221710000145", "rua um 132", "email@email.com", "password123", "11961063734");
    	Trasportadora t3 = new Trasportadora(null, "Super FastTrans", "52221710000145", "rua um 132", "email@email.com", "password123", "11961063734");
    	Trasportadora t4 = new Trasportadora(null, "Super FastTrans", "52221710000145", "rua um 132", "email@email.com", "password123", "11961063734");
		
		repository.saveAll(Arrays.asList(t1, t2, t3, t4));
		
		Cliente c1 = new Cliente(null, "Roberto Carnaúba Dias");
		Cliente c2 = new Cliente(null, "Pedro Coellho");
		Cliente c3 = new Cliente(null, "Madame Gazela");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Orcamento orc1 = new Orcamento(null, c1, "enderecoOrigem", "enderecoDestino", "dataDesejada", "dataLimite", Instant.parse("2020-07-20T15:21:22Z"), OrcamentoStatus.Aceito);
		Orcamento orc2 = new Orcamento(null, c1, "enderecoOrigem", "enderecoDestino", "dataDesejada", "dataLimite", Instant.parse("2020-07-20T15:21:22Z"), OrcamentoStatus.Recusado);
		Orcamento orc3 = new Orcamento(null, c1, "enderecoOrigem", "enderecoDestino", "dataDesejada", "dataLimite", Instant.parse("2020-07-20T15:21:22Z"), OrcamentoStatus.Recusado);
		
		orcamentoRepository.saveAll(Arrays.asList(orc1, orc2, orc3));
		
		Mudanca mud1 = new Mudanca(null, orc1, MudancaStatus.Iniciada);
		Mudanca mud2 = new Mudanca(null, orc1, MudancaStatus.Iniciada);
		
		mudancaRepository.saveAll(Arrays.asList(mud1, mud2));
	

		
	}
	
	
}
