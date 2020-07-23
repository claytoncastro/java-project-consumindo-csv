package com.desafio.resources;

import com.desafio.services.DadosImportacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dadosimportacao")
public class DadosImportacaoResource {

    @Autowired
    private DadosImportacaoService service;


}
