package com.desafio.resources;

import com.desafio.model.DadosImportacaoCSV;
import com.desafio.model.Historico;
import com.desafio.services.DadosImportacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Double mediaPrecoCombustivelPorMunicipio(@RequestBody String nomeMunicipio) {
        return service.mediaPrecoCombustivelPorMunicipio(nomeMunicipio);
    }

    @GetMapping("/porsiglaregiao")
    public ResponseEntity<List<DadosImportacaoCSV>> informacaoPorSiglaRegiao(@RequestBody String siglaEstado) {
        List<DadosImportacaoCSV> dadosImportacaoCSVS = service.informacaoPorSiglaRegiao(siglaEstado);
        return ResponseEntity.ok().body(dadosImportacaoCSVS);
    }


}
