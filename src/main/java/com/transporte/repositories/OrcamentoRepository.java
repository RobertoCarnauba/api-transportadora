package com.transporte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transporte.entities.Orcamento;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
}
