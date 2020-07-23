package com.desafio.services;

import com.desafio.model.Historico;

import java.util.List;

public interface HistoricoService {

    Historico save(Historico historico);

    Historico findById(Long id);

    List<Historico> findAll();

    Historico update(Historico historico);

    void delete(Long id);
    
}
