package com.transporte.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.transporte.entities.Cliente;
import com.transporte.entities.Endereco;
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
    	
    	Endereco end = new Endereco(1);
    	Endereco end1 = new Endereco(2);
    	
    	Trasportadora t1 = new Trasportadora(null, "Trans Rapidão", "49665753000105",end, "trasportadora@email.com", "password123", "17963236987");
    	Trasportadora t2 = new Trasportadora(null, "DevTransporte", "27244611000131",end1, "trasportadora@email.com", "123password", "11996897863");

		
		repository.saveAll(Arrays.asList(t1, t2));
		
		Cliente c1 = new Cliente(null, "Roberto C Dias", end, "email@test.com", "email123", "11963238498");
		Cliente c2 = new Cliente(null, "Thiago  Mininão", end, "email@test.com", "email123", "11963238498");
		Cliente c3 = new Cliente(null, "Bruno du Cabo", end, "email@test.com", "email123", "11963238498");
		
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3));
		Orcamento orc1 = new Orcamento(null, c1, end, end1, "17/08/2020", "17/08/2020", Instant.parse("2020-07-17T15:21:22Z"), OrcamentoStatus.Aceito);
		Orcamento orc2 = new Orcamento(null, c1,  end, end1, "19/08/2020", "17/08/2020", Instant.parse("2020-07-10T15:21:22Z"), OrcamentoStatus.Recusado);
		Orcamento orc3 = new Orcamento(null, c1,  end, end1, "7/10/2020", "17/08/2020", Instant.parse("2020-07-10T15:21:22Z"), OrcamentoStatus.Recusado);
		
		orcamentoRepository.saveAll(Arrays.asList(orc1, orc2, orc3));
		
		Mudanca mud1 = new Mudanca(null, orc1, MudancaStatus.Iniciada);
		Mudanca mud2 = new Mudanca(null, orc1, MudancaStatus.Iniciada);
		
		mudancaRepository.saveAll(Arrays.asList(mud1, mud2));
	

		
	}
	
	
}
