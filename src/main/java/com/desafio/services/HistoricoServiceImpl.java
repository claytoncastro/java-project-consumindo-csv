package com.desafio.services;

import com.desafio.model.Historico;
import com.desafio.repositories.HistoricoRepository;
import com.desafio.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoricoServiceImpl implements HistoricoService {

    @Autowired
    private HistoricoRepository repository;

    @Override
    public Historico save(Historico historico) {
        return repository.save(historico);
    }

    @Override
    public Historico findById(Long id) {
        Optional<Historico> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Historico.class.getName()));
    }

    @Override
    public List<Historico> findAll() {
        return repository.findAll();
    }

    @Override
    public Historico update(Historico historico) {
        findById(historico.getId());
        return repository.save(historico);
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

}
