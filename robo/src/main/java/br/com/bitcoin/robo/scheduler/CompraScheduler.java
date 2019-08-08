package br.com.bitcoin.robo.scheduler;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CompraScheduler {

    Integer quantidadeTransacoes = 0;

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
        quantidadeTransacoes++;
    }



}
