package com.desafio.services;

import java.io.IOException;
import java.text.ParseException;

public interface ImportacaoCSVService {

    void importarCSV() throws IOException, ParseException;

    void limparBase();

}
