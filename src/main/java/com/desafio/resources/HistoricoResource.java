package com.desafio.resources;

import com.desafio.model.Historico;
import com.desafio.services.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoResource {

    @Autowired
    private HistoricoService service;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Historico historico) {
        service.save(historico);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(historico.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Historico historico, @PathVariable Long id) {
        historico.setId(id);
        service.update(historico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Historico> find(@PathVariable(value = "id") Long id) {
        Historico historico = service.findById(id);
        return ResponseEntity.ok().body(historico);
    }

    @GetMapping
    public ResponseEntity<List<Historico>> findAll() {
        List<Historico> autorList = service.findAll();
        return ResponseEntity.ok().body(autorList);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
