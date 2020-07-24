package com.desafio.services;

import com.desafio.dto.DadosImportacaoCSVDTO;
import com.desafio.model.DadosImportacaoCSV;
import com.desafio.model.TipoValorMedio;

import java.util.List;

public interface DadosImportacaoService {

    DadosImportacaoCSVDTO mediaPrecoCombustivelPorMunicipio(String nomeMunicipio);

    List<DadosImportacaoCSV> informacaoPorSiglaRegiao(String siglaRegiao);

    void dadosAgrupados(Integer opcaoTipoDadosAgrupados);

    DadosImportacaoCSVDTO valorMedioCompraValorMedioVenda(TipoValorMedio opcaoTipoValorMedio, String municipioOuBandeira);

}
