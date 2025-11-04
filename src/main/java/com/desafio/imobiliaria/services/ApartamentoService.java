package com.desafio.imobiliaria.services;

import com.desafio.imobiliaria.model.Apartamento;
import com.desafio.imobiliaria.repository.ApartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ApartamentoService {
    @Autowired
    private ApartamentoRepository apartamentoRepository;

    public List<Apartamento> listarTodos(){
        return apartamentoRepository.findAll();
    }

    public Apartamento buscarPorId(Long id) {
        return apartamentoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Apartamento não encontrado"));
    }

    public Apartamento salvar(Apartamento apartamento) {
        if (!"São Paulo".equalsIgnoreCase(apartamento.getCidade())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é permitido cadastrar apartamentos em São Paulo");
        }
        return apartamentoRepository.save(apartamento);
    }

    public void deletar(Long id) {
        Apartamento apartamento = buscarPorId(id);
        apartamentoRepository.delete(apartamento);
    }

}

