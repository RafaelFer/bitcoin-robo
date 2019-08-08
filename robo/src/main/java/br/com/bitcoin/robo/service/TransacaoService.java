package br.com.bitcoin.robo.service;

import br.com.bitcoin.robo.modelo.Acao;
import br.com.bitcoin.robo.repository.AcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransacaoService {

    @Autowired
    private AcaoRepository acaoRepository;

    private static Long COMPRA = 1L;
    private static Long VENDA = 2L;


    public boolean ativaCompra(){
        try{
            Acao acao = acaoRepository.findById(COMPRA).get();
            acao.setAtivo(Boolean.TRUE);
            acaoRepository.save(acao);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean desativaCompra(){
        try{
            Acao acao = acaoRepository.findById(COMPRA).get();
            acao.setAtivo(Boolean.FALSE);
            acaoRepository.save(acao);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
