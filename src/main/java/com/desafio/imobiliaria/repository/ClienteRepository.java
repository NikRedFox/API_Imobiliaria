package com.desafio.imobiliaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.desafio.imobiliaria.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
