package com.desafio.dto;

import com.desafio.model.DadosImportacaoCSV;

import java.io.Serializable;

public class DadosImportacaoCSVDTO implements Serializable {

    private Double valorVenda;
    private Double valorCompra;
    private String bandeira;
    private String municipio;
    private String siglaRegiao;
    private Double mediaValorVenda;
    private Double mediaValorCompra;

    public DadosImportacaoCSVDTO(Double valorVenda, Double valorCompra, String bandeira, String municipio,
                                 String siglaRegiao) {
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
        this.bandeira = bandeira;
        this.municipio = municipio;
        this.siglaRegiao = siglaRegiao;
    }

    public DadosImportacaoCSVDTO() {}

    public Double getValorVenda() {
        return valorVenda;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public String getBandeira() {
        return bandeira;
    }

    public String getMunicipio() {
        return municipio;
    }

    public String getSiglaRegiao() {
        return siglaRegiao;
    }

    public Double getMediaValorVenda() {
        return mediaValorVenda;
    }

    public Double getMediaValorCompra() {
        return mediaValorCompra;
    }

    public static DadosImportacaoCSVDTO transformaEmDTO(DadosImportacaoCSV dadosImportacaoCSV) {
        return new DadosImportacaoCSVDTO(dadosImportacaoCSV.getValorVenda(), dadosImportacaoCSV.getValorCompra(),
                dadosImportacaoCSV.getBandeira(), dadosImportacaoCSV.getMunicipio(), dadosImportacaoCSV.getSiglaRegiao());
    }

}
