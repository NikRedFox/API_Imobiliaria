package com.desafio.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio.imobiliaria.model.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long>{
}
