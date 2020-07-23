package com.desafio.services;

import com.desafio.model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    Usuario findById(Long id);

    List<Usuario> findAll();

    Usuario update(Usuario usuario);

    void delete(Long id);

}
