package br.com.bitcoin.robo.domain;


public class ParamComum {


    String tapiMethod;
    String tapiNonce;

    public ParamComum(String tapiMethod, String tapiNonce) {
        this.tapiMethod = tapiMethod;
        this.tapiNonce = tapiNonce;
    }

    public void setTapiMethod(String tapiMethod) {
        this.tapiMethod = tapiMethod;
    }

    public void setTapiNonce(String tapiNonce) {
        this.tapiNonce = tapiNonce;
    }

    public String buildFormatado(){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?tapi_method:"+this.tapiMethod+"&tapi_nonce="+tapiNonce);
        return stringBuilder.toString();
    }


}
