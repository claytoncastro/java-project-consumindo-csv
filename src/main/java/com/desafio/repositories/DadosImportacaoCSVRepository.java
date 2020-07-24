package com.desafio.repositories;

import com.desafio.dto.DadosImportacaoCSVDTO;
import com.desafio.model.DadosImportacaoCSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DadosImportacaoCSVRepository extends JpaRepository<DadosImportacaoCSV, Long> {

    @Query("SELECT dicsv FROM DadosImportacaoCSV dicsv WHERE "
            + "(lower(dicsv.municipio) like lower(:municipio))")
    List<DadosImportacaoCSV> findValoresByMunicipio(@Param("municipio") String municipio);

    @Query("SELECT dicsv FROM DadosImportacaoCSV dicsv WHERE "
            + "(lower(dicsv.siglaRegiao) like lower(:siglaRegiao))")
    List<DadosImportacaoCSV> findAllDadosImportacaoCsvsBySiglaRegiao(@Param("siglaRegiao") String siglaRegiao);

    @Query("SELECT dicsv FROM DadosImportacaoCSV dicsv WHERE "
            + "(lower(dicsv.bandeira) like lower(:bandeira))")
    List<DadosImportacaoCSV> findValorMedioCompraValorMedioVendaByBandeira(@Param("bandeira") String bandeira);

}
