package com.desafio.services;

import com.desafio.model.DadosAgrupados;
import com.desafio.model.TipoDadosAgrupados;
import com.desafio.model.TipoValorMedio;
import com.desafio.model.ValorMedio;
import org.springframework.stereotype.Service;

@Service
public class DadosImportacaoServiceImpl implements DadosImportacaoService {

    @Override
    public void mediaPrecoCombustivelPorMunicipio() {

    }

    @Override
    public void informacaoPorSiglaRegiao() {

    }

    @Override
    public void dadosAgrupados(Integer opcaoTipoDadosAgrupados) {
        TipoDadosAgrupados tipoDadosAgrupados = TipoDadosAgrupados.values()[opcaoTipoDadosAgrupados - 1];
        DadosAgrupados dados = tipoDadosAgrupados.obterTipoDadosAgrupados();
        dados.dadosAgrupados();
//        return ...
    }

    @Override
    public Double valorMedioCompraVenda(Integer opcaoTipoValorMedio) {
        TipoValorMedio tipoValorMedio = TipoValorMedio.values()[opcaoTipoValorMedio - 1];
        ValorMedio valorMedio = tipoValorMedio.obterValorMedio();
        return valorMedio.valorMedioCompraVenda();
    }

}
