package br.com.bitcoin.robo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {


    @GetMapping("/compra")
    public ResponseEntity<Object> listaUsuarios() {
        return ResponseEntity.ok("Iniciado Compras!");
    }
}
