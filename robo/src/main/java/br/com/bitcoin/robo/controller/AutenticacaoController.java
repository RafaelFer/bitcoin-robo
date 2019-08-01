package br.com.bitcoin.robo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @PostMapping
    public ResponseEntity<?> autenticar() {
            return ResponseEntity.ok().build();
    }
}
