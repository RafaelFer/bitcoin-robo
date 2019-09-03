package br.com.bitcoin.robo.teste;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Comparacao {


    public static void main(String[] args) {
        comparaEMostraDiferencas();
    }

    public static void comparaEMostraDiferencas() {

        ObjetoClienteAdaptado objetoClienteAdaptado = new ObjetoClienteAdaptado(1L, "Rafael Ferreira", 123L, "Rua da Independencia", "46541200");

        ObjetoClienteDDI objetoClienteDDI = new ObjetoClienteDDI(1L, "Rafael Ferreeira", 123L, "Rua da Independencia", "46541200-2");

        Map<String, String> diferencas = new HashMap<String, String>();

        if (!objetoClienteAdaptado.getId().equals(objetoClienteDDI.getId())) {
            diferencas.put("id", "("+objetoClienteAdaptado.getId().toString() +")  ("+objetoClienteDDI.getId()+")");
        }
        if (!objetoClienteAdaptado.getNome().trim().equals(objetoClienteDDI.getNome().trim())) {
            diferencas.put("nome", "("+objetoClienteAdaptado.getNome() + ")  ("+ objetoClienteDDI.getNome()+")");
        }
        if (objetoClienteAdaptado.getCpf() != objetoClienteDDI.getCpf()) {
            diferencas.put("cpf", "("+objetoClienteAdaptado.getCpf().toString() + ") ("+objetoClienteDDI.getCpf()+")");
        }
        if (!objetoClienteAdaptado.getRg().trim().equals(objetoClienteDDI.getRg())) {
            diferencas.put("rg", "("+objetoClienteAdaptado.getRg() +") ("+objetoClienteDDI.getRg()+")");
        }
        if (!objetoClienteAdaptado.getEndereco().trim().equals(objetoClienteDDI.getEndereco().trim())) {
            diferencas.put("endereco", "("+objetoClienteAdaptado.getEndereco() +") ("+objetoClienteDDI.getEndereco()+")");
        }

        System.out.println("Campos Diferentes: \n");

        for (Map.Entry<String, String> stringStringEntry : diferencas.entrySet()) {
            System.out.println(stringStringEntry);
        }

    }


}




