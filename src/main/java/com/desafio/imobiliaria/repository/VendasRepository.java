package com.desafio.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio.imobiliaria.model.Vendas;

public interface VendasRepository extends JpaRepository<Vendas, Long>{
}