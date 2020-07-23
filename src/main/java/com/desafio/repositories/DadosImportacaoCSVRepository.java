package com.desafio.repositories;

import com.desafio.model.DadosImportacaoCSV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosImportacaoCSVRepository extends JpaRepository<DadosImportacaoCSV, Long> {
}
