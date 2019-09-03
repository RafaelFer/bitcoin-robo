package br.com.bitcoin.robo.Util;

import org.junit.Assert;
import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;


public class HmacUtilTest {

    private static final String HMAC_SHA512 = "HmacSHA512";


    @Test
    public void calculateHMAC() throws NoSuchAlgorithmException, InvalidKeyException {

        String key = "1ebda7d457ece1330dff1c9e04cd62c4e02d1835968ff89d2fb2339f06f73028";
        String data = "/tapi/v3/?tapi_method=list_orders&tapi_nonce=1";

        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(),HMAC_SHA512);

        Mac mac = Mac.getInstance(HMAC_SHA512);
        mac.init(secretKeySpec);


        Assert.assertEquals("7f59ea8749ba596d5c23fa242a531746b918e5e61c9f6c8663a699736db503980f3a507ff7e2ef1336f7888d684a06c9a460d18290e7b738a61d03e25ffdeb76", toHexString(mac.doFinal(data.getBytes())));

    }


    private static String toHexString(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }
}