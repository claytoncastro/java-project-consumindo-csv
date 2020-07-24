package com.desafio.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable {

    private String nome;
    private String login;

    public UsuarioDTO(String nome, String login) {
        this.nome = nome;
        this.login = login;
    }

    public UsuarioDTO() {}

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

}
