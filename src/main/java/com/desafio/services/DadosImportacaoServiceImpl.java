package com.desafio.services;

import com.desafio.model.DadosImportacaoCSV;
import com.desafio.model.TipoValorMedio;
import com.desafio.repositories.DadosImportacaoCSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DadosImportacaoServiceImpl implements DadosImportacaoService {

    @Autowired
    private DadosImportacaoCSVRepository repository;

    @Override
    public Double mediaPrecoCombustivelPorMunicipio(String nomeMunicipio) {
        return repository.findValoresByMunicipio(nomeMunicipio)
                .stream().mapToDouble(valor -> valor.doubleValue())
                .average().orElse(0.0);
    }

    @Override
    public List<DadosImportacaoCSV> informacaoPorSiglaRegiao(String siglaRegiao) {
        return repository.findAllDadosImportacaoCsvsBySiglaRegiao(siglaRegiao);
    }

    @Override
    public void dadosAgrupados(Integer opcaoTipoDadosAgrupados) {
        /** Consultas baseadas em agrupamento por:
         *  distribuidora e agrupamento por data da coleta */
    }

    @Override
    public void valorMedioCompraValorMedioVenda(TipoValorMedio opcaoTipoValorMedio) {
        List<DadosImportacaoCSV> valores = new ArrayList<>();
        switch (opcaoTipoValorMedio) {
            case BANDEIRA:
                valores = repository.findValorMedioCompraValorMedioVendaByBandeira("bandeira");
                break;
            case MUNICIPIO:
                valores = repository.findValorMedioCompraValorMedioVendaByMunicipio("municipio");
                break;
            default: System.out.println("Default");
        }
    }

}
