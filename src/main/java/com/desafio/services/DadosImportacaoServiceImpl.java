package com.desafio.services;

import com.desafio.dto.DadosImportacaoCSVDTO;
import com.desafio.model.DadosImportacaoCSV;
import com.desafio.model.TipoDadosAgrupados;
import com.desafio.model.TipoValorMedio;
import com.desafio.repositories.DadosImportacaoCSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DadosImportacaoServiceImpl implements DadosImportacaoService {

    @Autowired
    private DadosImportacaoCSVRepository repository;

    @Override
    public DadosImportacaoCSVDTO mediaPrecoCombustivelPorMunicipio(String nomeMunicipio) {
        List<DadosImportacaoCSV> dadosImportacaoCSV = repository.findValoresByMunicipio(nomeMunicipio);
        Map<String, Double> valoresMap = obterMediaValores(dadosImportacaoCSV);
        return new DadosImportacaoCSVDTO(valoresMap.get("mediaValorVenda"), valoresMap.get("mediaValorCompra"));
    }

    @Override
    public List<DadosImportacaoCSV> informacaoPorSiglaRegiao(String siglaRegiao) {
        return repository.findAllDadosImportacaoCsvsBySiglaRegiao(siglaRegiao);
    }

    @Override
    public List<DadosImportacaoCSV> dadosAgrupados(TipoDadosAgrupados opcaoTipoDadosAgrupados) {

        switch (opcaoTipoDadosAgrupados) {
            case DISTRIBUIDORA:
                return repository.findAllDadosOrderByDistribuidora();

            case DATA_COLETA:
                return repository.findAllDadosOrderByDataColeta();

            default: return null;
        }
    }

    @Override
    public DadosImportacaoCSVDTO valorMedioCompraValorMedioVenda(TipoValorMedio opcaoTipoValorMedio, String municipioOuBandeira) {
        List<DadosImportacaoCSV> dadosImportacaoCSV;

        switch (opcaoTipoValorMedio) {
            case MUNICIPIO:
                return mediaPrecoCombustivelPorMunicipio(municipioOuBandeira);

            case BANDEIRA:
                dadosImportacaoCSV = repository.findValorMedioCompraValorMedioVendaByBandeira(municipioOuBandeira);
                Map<String, Double> mediaPorBandeira = obterMediaValores(dadosImportacaoCSV);
                return new DadosImportacaoCSVDTO(mediaPorBandeira.get("mediaValorVenda"),
                        mediaPorBandeira.get("mediaValorCompra"));

            default: return new DadosImportacaoCSVDTO();
        }
    }

    private Map<String, Double> obterMediaValores(List<DadosImportacaoCSV> dadosImportacaoCSV) {
        Map<String, Double> valoresMap = new HashMap<>();

        Double mediaValorCompra = dadosImportacaoCSV.stream()
                .mapToDouble(dados -> dados.getValorCompra() != null ? dados.getValorVenda() : 0.0)
                .average().orElse(0.0);
        valoresMap.put("mediaValorCompra", mediaValorCompra);

        Double mediaValorVenda = dadosImportacaoCSV.stream()
                .mapToDouble(dados -> dados.getValorVenda() != null ? dados.getValorVenda() : 0.0)
                .average().orElse(0.0);
        valoresMap.put("mediaValorVenda", mediaValorVenda);

        return valoresMap;
    }

}
