package com.desafio.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="vendas")

public class Vendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long vendaId;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "apartamento_id", nullable = false)
    private Apartamento apartamento;

    @Column(nullable = false)
    private LocalDateTime dataVenda;

    @Column(nullable = false)
    private BigDecimal valorVenda;

    public Vendas() {}

    public Vendas(Cliente cliente, Apartamento apartamento, LocalDateTime dataVenda, BigDecimal valorVenda) {
        this.cliente = cliente;
        this.apartamento = apartamento;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
    }

    public Cliente getCliente(){return cliente;}
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Apartamento getApartamento(){return apartamento;}
    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento;
    }

    public LocalDateTime getDataVenda(){return dataVenda;}
    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }

    public BigDecimal getValorVenda(){return valorVenda;}
    public void setValorVenda(BigDecimal valorVenda) {
        this.valorVenda = valorVenda;
    }
}
