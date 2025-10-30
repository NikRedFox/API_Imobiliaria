package com.desafio.imobiliaria.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
@Table(name="apartamento")

public class Apartamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long codigo;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private Integer quartos;

    @Column(nullable = false)
    private Double area;

    @Column(nullable = false)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusAP status;

    public Apartamento(){}

    public Apartamento(
        String endereco,
        Integer quartos,
        Double area,
        BigDecimal preco,
        StatusAP status
    ){
        this.endereco = endereco;
        this.quartos = quartos;
        this.area = area;
        this.preco = preco;
        this.status = status;
    }

    public Long getCodigo(){return codigo;}
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getEndereco(){return endereco;}
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getQuartos(){return quartos;}
    public void setQuartos(Integer quartos) {
        this.quartos = quartos;
    }

    public Double getArea(){return area;}
    public void setArea(Double area) {
        this.area = area;
    }

    public BigDecimal getPreco(){return preco;}
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusAP getStatus(){return status;}
    public void setStatus(StatusAP status) {
        this.status = status;
    }
}
