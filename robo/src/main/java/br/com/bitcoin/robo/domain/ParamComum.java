package br.com.bitcoin.robo.domain;


public class ParamComum {


    String tapiMethod;

    String tapiNonce;

    public ParamComum(String tapiMethod) {
        this.tapiMethod = tapiMethod;
        this.tapiNonce =  String.valueOf(System.currentTimeMillis());
    }

    public void setTapiMethod(String tapiMethod) {
        this.tapiMethod = tapiMethod;
    }

    public void setTapiNonce(String tapiNonce) {
        this.tapiNonce = tapiNonce;
    }

    public String buildUrlInteira(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/tapi/v3/?tapi_method="+this.tapiMethod+"&tapi_nonce="+tapiNonce);
        return stringBuilder.toString();
    }

    public String buildPath(){

        Long once = System.currentTimeMillis();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/tapi/v3/?tapi_method="+this.tapiMethod+"&tapi_nonce="+once.toString().substring(8,13));
        return stringBuilder.toString();
    }


}
