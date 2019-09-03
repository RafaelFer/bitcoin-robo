package br.com.bitcoin.robo.scheduler;


import br.com.bitcoin.robo.service.TransacaoCompraService;
import br.com.bitcoin.robo.service.TransacaoVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class CompraVendaScheduler {

    private Integer quantidadeTransacoes = 0;

    @Autowired
    private TransacaoCompraService transacaoCompraService;

    @Autowired
    private TransacaoVendaService transacaoVendaService;

    @Scheduled(fixedDelay = 5000)
    public void compraACada4Segundos() {
//        transacaoCompraService.efetivaCompra();
    }

    @Scheduled(fixedDelay = 4000)
    public void vendeACada4Segundos() {
//        transacaoVendaService.efetivaVenda();
    }

    @Scheduled(fixedDelay = 10000)
    public void ataulizaStatusACada4Segundos() {
        quantidadeTransacoes++;
    }



}
