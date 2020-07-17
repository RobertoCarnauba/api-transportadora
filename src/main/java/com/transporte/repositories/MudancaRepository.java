package com.transporte.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transporte.entities.Mudanca;

public interface MudancaRepository extends JpaRepository<Mudanca, Integer> {
}
