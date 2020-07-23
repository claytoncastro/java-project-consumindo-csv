package com.desafio.services;

import com.desafio.model.Localidade;
import com.desafio.repositories.DadosImportacaoCSVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ImportacaoCSVServiceImpl implements ImportacaoCSVService {

    @Autowired
    private DadosImportacaoCSVRepository repository;

    private final String PATH_ARQUIVO = "src/main/resources/2019-1_CA.csv";
    private final String CHARSET = "CP1252";

    @Override
    public void importarCSV() throws IOException, ParseException {

        String[] linhas = obterLinhasArquivoCSV();

        for (String linha : linhas) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            Localidade dadosImportacaoCSV = new Localidade();
            String[] coluna = linha.split(";");
            dadosImportacaoCSV.setSiglaRegiao(coluna[0]);
            dadosImportacaoCSV.setSiglaEstado(coluna[1]);
            dadosImportacaoCSV.setMunicipio(coluna[2]);
            dadosImportacaoCSV.setRevenda(coluna[3]);
            dadosImportacaoCSV.setCnpjRevenda(coluna[4]);
            dadosImportacaoCSV.setProduto(coluna[5]);
            String dataString = coluna[6];
            Date dataColeta = format.parse(dataString);
            dadosImportacaoCSV.setDataColeta(dataColeta);
            if (!coluna[7].isEmpty()) {
                String valorVenda = coluna[7].replace(",", ".");
                dadosImportacaoCSV.setValorVenda(Double.parseDouble(valorVenda));
            }
            if (!coluna[8].isEmpty()) {
                String valorCompra = coluna[8].replace(",", ".");
                dadosImportacaoCSV.setValorCompra(Double.parseDouble(valorCompra));
            }
            dadosImportacaoCSV.setUnidadeMedida(coluna[9]);
            dadosImportacaoCSV.setBandeira(coluna[10]);

            repository.save(dadosImportacaoCSV);
        }
    }

    @Override
    public void limparBase(){
        //Limpa a base para poder importar o CSV novamente sem duplicar
        repository.deleteAll();
    }

    private String[] obterLinhasArquivoCSV() throws IOException {
        try(BufferedReader myBuffer = new BufferedReader(new InputStreamReader(
                new FileInputStream(PATH_ARQUIVO), CHARSET))) {

            String linha = myBuffer.readLine();
            String csv = "";

            while (linha != null) {
                String linha_ = linha.replace("\"", "");
                csv += linha_ + "\n";
                linha = myBuffer.readLine();
            }
            return csv.split("\\n");
        }
    }

}
