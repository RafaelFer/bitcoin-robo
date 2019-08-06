package br.com.bitcoin.robo.controller;


import br.com.bitcoin.robo.controller.dto.UsuarioDto;
import br.com.bitcoin.robo.modelo.Usuario;
import br.com.bitcoin.robo.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<?> autenticar() {
            return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Object> listaUsuarios() {
        return ResponseEntity.ok(UsuarioDto.converter( usuarioRepository.findAll()));
    }
}
