package br.com.bitcoin.robo.scheduler;


import br.com.bitcoin.robo.modelo.Acao;
import br.com.bitcoin.robo.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
public class CompraScheduler {

    Integer quantidadeTransacoes = 0;

    @Autowired
    private AcaoRepository acaoRepository;

    @Scheduled(fixedDelay = 4000)
    public void compraACada4Segundos() {
        System.out.println("Comprando a cada 4 segundos!");
    }

    @Scheduled(fixedDelay = 4000)
    public void vendeACada4Segundos() {
        System.out.println("Vendendo a cada 4 segundos!");
    }

    @Scheduled(fixedDelay = 10000)
    public void ataulizaStatusACada4Segundos() {

        System.out.println("Status a cada 12 segundos!");
        System.out.println("Quanidade de transacoes "+quantidadeTransacoes);

        List<Acao> acoes = acaoRepository.findAll();

        acoes.forEach( acao -> {
            System.out.println("ID > "+ acao.getId() +" "+ acao.getAcao() + " -> "+acao.getAtivo());
        });

        quantidadeTransacoes++;
    }



}
