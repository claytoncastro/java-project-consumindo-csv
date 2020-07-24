package com.desafio.dto;

import java.io.Serializable;

public class DadosImportacaoCSVDTO implements Serializable {

    private Double mediaValorVenda;
    private Double mediaValorCompra;

    public DadosImportacaoCSVDTO(Double mediaValorVenda, Double mediaValorCompra) {
        this.mediaValorVenda = mediaValorVenda;
        this.mediaValorCompra = mediaValorCompra;
    }

    public DadosImportacaoCSVDTO(){}

    public Double getMediaValorVenda() {
        return mediaValorVenda;
    }
    public Double getMediaValorCompra() {
        return mediaValorCompra;
    }

}
