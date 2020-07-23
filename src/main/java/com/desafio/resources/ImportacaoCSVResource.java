package com.desafio.resources;

import com.desafio.services.ImportacaoCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.ParseException;

@RestController
@RequestMapping("/importacao")
public class ImportacaoCSVResource {

    @Autowired
    private ImportacaoCSVService service;

    @PostMapping
    public void importarCSV(@RequestBody String path) throws IOException, ParseException {
        service.importarCSV(path);
    }

    @DeleteMapping
    public void limparBase() {
        service.limparBase();
    }
}
