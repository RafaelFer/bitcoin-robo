package br.com.bitcoin.robo.controller;

import br.com.bitcoin.robo.modelo.Acao;
import br.com.bitcoin.robo.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private AcaoRepository acaoRepository;

    private static Long COMPRA = 1L;
    private static Long VENDA = 2L;


    @GetMapping("/compra/ativa")
    public ResponseEntity<Object> ativandoCompra() {
        Acao acao = acaoRepository.findById(COMPRA).get();
        acao.setAtivo(Boolean.TRUE);
        acaoRepository.save(acao);
        return ResponseEntity.ok("Ativa Compras!");
    }

    @GetMapping("/compra/desativa")
    public ResponseEntity<Object> desativaCompra() {
        Acao acao = acaoRepository.findById(COMPRA).get();
        acao.setAtivo(Boolean.FALSE);
        acaoRepository.save(acao);
        return ResponseEntity.ok("Desativa Compras!");
    }


}
