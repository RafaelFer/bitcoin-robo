package br.com.bitcoin.robo.controller;

import br.com.bitcoin.robo.controller.dto.UsuarioDto;
import br.com.bitcoin.robo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saldo")
public class SaldoController {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping("/contas")
    public ResponseEntity<Object> listaUsuarios() {
        return ResponseEntity.ok(UsuarioDto.converter( usuarioRepository.findAll()));
    }

}
