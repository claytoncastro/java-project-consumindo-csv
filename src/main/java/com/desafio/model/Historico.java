package com.desafio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Historico implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double precoCombustivelCompra;
    private Double precoCombustivelVenda;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecoCombustivelCompra() {
        return precoCombustivelCompra;
    }

    public void setPrecoCombustivelCompra(Double precoCombustivelCompra) {
        this.precoCombustivelCompra = precoCombustivelCompra;
    }

    public Double getPrecoCombustivelVenda() {
        return precoCombustivelVenda;
    }

    public void setPrecoCombustivelVenda(Double precoCombustivelVenda) {
        this.precoCombustivelVenda = precoCombustivelVenda;
    }

}
