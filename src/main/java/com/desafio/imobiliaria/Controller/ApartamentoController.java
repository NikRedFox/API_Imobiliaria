package com.desafio.imobiliaria.Controller;

import com.desafio.imobiliaria.model.Apartamento;
import com.desafio.imobiliaria.services.ApartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartamentos")
public class ApartamentoController {

    @Autowired
    private ApartamentoService apartamentoService;

    @GetMapping
    public List<Apartamento> listar() {
        return apartamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Apartamento buscarPorId(@PathVariable Long id) {
        return apartamentoService.buscarPorId(id);
    }

    @PostMapping
    public Apartamento criar(@RequestBody Apartamento apartamento) {
        return apartamentoService.salvar(apartamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        apartamentoService.deletar(id);
    }
}
