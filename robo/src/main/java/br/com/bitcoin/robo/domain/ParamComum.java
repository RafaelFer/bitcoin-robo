package br.com.bitcoin.robo.domain;


public class ParamComum {


    String tapiMethod;

    String tapiNonce;

    public ParamComum(String tapiMethod) {
        this.tapiMethod = tapiMethod;
        this.tapiNonce =  String.valueOf(System.currentTimeMillis());
    }

    public String buildPath(){

        Long once = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/tapi/v3/?tapi_method="+this.tapiMethod+"&tapi_nonce="+once);

        return stringBuilder.toString();
    }


}