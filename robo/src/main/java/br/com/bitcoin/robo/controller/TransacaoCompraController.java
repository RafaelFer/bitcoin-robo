package br.com.bitcoin.robo.controller;

import br.com.bitcoin.robo.service.TransacaoCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/transacao/compra")
public class TransacaoCompraController {


    @Autowired
    private TransacaoCompraService transacaoCompraService;

    @PostMapping("ativa")
    public ResponseEntity<Object> ativaCompra() {
        if(transacaoCompraService.ativaCompra()){
            System.out.println("ATIVANDO COMPRA");
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("desativa")
    public ResponseEntity<Object> desativaCompra() {
        if(transacaoCompraService.desativaCompra()){
            System.out.println("DESATIVANDO COMPRA");
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }


}
