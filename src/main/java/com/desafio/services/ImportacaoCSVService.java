package com.desafio.services;

import java.io.IOException;
import java.text.ParseException;

public interface ImportacaoCSVService {

    void importarCSV(String path) throws IOException, ParseException;

    void limparBase();

}
