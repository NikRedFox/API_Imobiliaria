package com.desafio.imobiliaria.Controller;

import com.desafio.imobiliaria.model.Vendas;
import com.desafio.imobiliaria.services.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @GetMapping
    public List<Vendas> listar() {
        return vendasService.listarTodas();
    }

    @GetMapping("/{id}")
    public Vendas buscarPorId(@PathVariable Long id) {
        return vendasService.buscarPorId(id);
    }

    @PostMapping
    public Vendas registrarVenda(@RequestBody Vendas venda) {
        return vendasService.registrarVenda(venda);
    }
}

