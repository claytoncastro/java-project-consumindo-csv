package com.desafio.resources;

import com.desafio.dto.UsuarioDTO;
import com.desafio.model.Usuario;
import com.desafio.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Usuario usuario) {
        Usuario user = service.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody Usuario usuario, @PathVariable Long id) {
        usuario.setId(id);
        service.update(usuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> find(@PathVariable(value = "id") Long id) {
        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario.getNome(), usuario.getLogin()));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<Usuario> usuarioList = service.findAll();
        List<UsuarioDTO> livroDto = usuarioList.stream()
                .map(usuario -> new UsuarioDTO(usuario.getNome(), usuario.getLogin()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(livroDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
