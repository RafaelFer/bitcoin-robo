package br.com.bitcoin.robo.service;

import br.com.bitcoin.robo.modelo.Acao;
import br.com.bitcoin.robo.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoVendaService {

    @Autowired
    private AcaoRepository acaoRepository;

    private static Long VENDA = 2L;


    public boolean ativaVenda(){
        try{
            Acao acao = acaoRepository.findById(VENDA).get();
            acao.setAtivo(Boolean.TRUE);
            acaoRepository.save(acao);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean desativaVenda(){
        try{
            Acao acao = acaoRepository.findById(VENDA).get();
            acao.setAtivo(Boolean.FALSE);
            acaoRepository.save(acao);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void efetivaVenda(){
        Acao acao = acaoRepository.findById(VENDA).get();
        if(acao.getAtivo()){
            //Logica para chamar a api
            System.out.println("disparando VENDA para MERCADO BITCOIN");
        }
    }
}
