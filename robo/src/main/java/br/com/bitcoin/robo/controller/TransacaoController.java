package br.com.bitcoin.robo.controller;

import br.com.bitcoin.robo.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transacao/compra")
public class TransacaoController {


    @Autowired
    private TransacaoService transacaoService;

    @GetMapping("ativa")
    public ResponseEntity<Object> ativaCompra() {
        if(transacaoService.ativaCompra()){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("desativa")
    public ResponseEntity<Object> desativaCompra() {
        if(transacaoService.desativaCompra()){
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
