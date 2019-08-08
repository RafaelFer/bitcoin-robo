package br.com.bitcoin.robo.controller;

import br.com.bitcoin.robo.service.TransacaoVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao/venda")
public class TransacaoVendaController {


    @Autowired
    private TransacaoVendaService transacaoVendaService;

    @PostMapping("ativa")
    public ResponseEntity<Object> ativaVenda() {
        if(transacaoVendaService.ativaVenda()){
            System.out.println("ATIVANDO VENDA");
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("desativa")
    public ResponseEntity<Object> desativaVenda() {
        if(transacaoVendaService.desativaVenda()){
            System.out.println("DESATIVANDO VENDA");
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }



}
