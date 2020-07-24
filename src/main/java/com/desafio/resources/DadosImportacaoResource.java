package com.desafio.resources;

import com.desafio.dto.DadosImportacaoCSVDTO;
import com.desafio.model.DadosImportacaoCSV;
import com.desafio.model.TipoDadosAgrupados;
import com.desafio.model.TipoValorMedio;
import com.desafio.services.DadosImportacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dadosimportacao")
public class DadosImportacaoResource {

    @Autowired
    private DadosImportacaoService service;

    @GetMapping
    public ResponseEntity<DadosImportacaoCSVDTO> mediaPrecoCombustivelPorMunicipio(@RequestBody String nomeMunicipio) {
        DadosImportacaoCSVDTO dadosImportacaoCSVDTO = service.mediaPrecoCombustivelPorMunicipio(nomeMunicipio);
        return ResponseEntity.ok().body(dadosImportacaoCSVDTO);
    }

    @GetMapping("/porsiglaregiao")
    public ResponseEntity<List<DadosImportacaoCSV>> informacaoPorSiglaRegiao(@RequestBody String siglaEstado) {
        List<DadosImportacaoCSV> dadosImportacaoCSVS = service.informacaoPorSiglaRegiao(siglaEstado);
        return ResponseEntity.ok().body(dadosImportacaoCSVS);
    }

    @GetMapping("/dadosAgrupados/{id}")
    public ResponseEntity<List<DadosImportacaoCSV>> dadosAgrupados(
            @PathVariable(value = "id") int opcaoTipoDadosAgrupados) {
        List<DadosImportacaoCSV> dadosImportacaoCSVS = service
                .dadosAgrupados(TipoDadosAgrupados.values()[opcaoTipoDadosAgrupados]);
        return ResponseEntity.ok().body(dadosImportacaoCSVS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DadosImportacaoCSVDTO> valorMedioCompraValorMedioVenda(
            @PathVariable(value = "id") int opcaoTipoValorMedio, @RequestBody String municipioOuBandeira) {
        DadosImportacaoCSVDTO dadosImportacaoCSVDTO = service
                .valorMedioCompraValorMedioVenda(TipoValorMedio.values()[opcaoTipoValorMedio], municipioOuBandeira);
        return ResponseEntity.ok().body(dadosImportacaoCSVDTO);
    }

}
