package com.desafio.dto;

import java.io.Serializable;

public class HistoricoDTO implements Serializable {

    private Double precoCombustivelCompra;
    private Double precoCombustivelVenda;

    public HistoricoDTO(Double precoCombustivelCompra, Double precoCombustivelVenda) {
        this.precoCombustivelCompra = precoCombustivelCompra;
        this.precoCombustivelVenda = precoCombustivelVenda;
    }

    public HistoricoDTO() {}

    public Double getPrecoCombustivelCompra() {
        return precoCombustivelCompra;
    }

    public Double getPrecoCombustivelVenda() {
        return precoCombustivelVenda;
    }

}
