package br.com.bitcoin.robo.scheduler;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class CompraScheduler {

    Integer quantidadeTransacoes = 0;

    @Scheduled(fixedDelay = 4000)
    public void compraACada4Segundos()
    {
    }

    @Scheduled(fixedDelay = 4000)
    public void vendeACada4Segundos() {
    }

    @Scheduled(fixedDelay = 10000)
    public void ataulizaStatusACada4Segundos() {
        quantidadeTransacoes++;
    }



}
