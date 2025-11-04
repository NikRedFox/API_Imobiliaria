package com.desafio.imobiliaria.services;

import com.desafio.imobiliaria.model.Cliente;
import com.desafio.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarTodos(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    public Cliente salvar(Cliente cliente) {
        if ((cliente.getCpf() == null || cliente.getCpf().isBlank()) &&
                (cliente.getCnpj() == null || cliente.getCnpj().isBlank())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "É obrigatório informar CPF ou CNPJ");
        }
        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }

}
