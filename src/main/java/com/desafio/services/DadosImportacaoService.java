package com.desafio.services;

import com.desafio.model.DadosImportacaoCSV;
import com.desafio.model.TipoValorMedio;

import java.util.List;

public interface DadosImportacaoService {

    Double mediaPrecoCombustivelPorMunicipio(String nomeMunicipio);

    List<DadosImportacaoCSV> informacaoPorSiglaRegiao(String siglaRegiao);

    void dadosAgrupados(Integer opcaoTipoDadosAgrupados);

    void valorMedioCompraValorMedioVenda(TipoValorMedio opcaoTipoValorMedio);

}
