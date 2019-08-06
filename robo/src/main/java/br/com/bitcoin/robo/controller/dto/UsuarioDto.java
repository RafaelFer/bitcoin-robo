package br.com.bitcoin.robo.controller.dto;

import br.com.bitcoin.robo.modelo.Usuario;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDto {

    private Long id;
    private String nome;
    private String email;

    public UsuarioDto(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public static List<UsuarioDto> converter(List<Usuario> usuarios) {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
         usuarios.forEach( u -> {
             usuarioDtos.add(new UsuarioDto(u.getId(),u.getNome(),u.getEmail()));
        });
        return usuarioDtos;
    }
}
