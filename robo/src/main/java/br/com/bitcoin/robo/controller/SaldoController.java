package br.com.bitcoin.robo.controller;

import br.com.bitcoin.robo.Util.HmacUtil;
import br.com.bitcoin.robo.controller.dto.UsuarioDto;
import br.com.bitcoin.robo.domain.ParamComum;
import br.com.bitcoin.robo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.Arrays;

@RestController
@RequestMapping("/informacao/")
public class SaldoController {


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${chave.api.tapi.identificador}")
    private String identificador;

    @Value("${chave.api.tapi.segredo}")
    private String secret;

    @Value("${url.mercado.bitcoin}")
    private String urlMercadoBitcoin;

    @GetMapping("/contas")
    public ResponseEntity<Object> listaUsuarios() {
        return ResponseEntity.ok(UsuarioDto.converter( usuarioRepository.findAll()));
    }

    @GetMapping("/teste")
    public ResponseEntity exemplo() {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);


        return ResponseEntity.ok(restTemplate.exchange("https://www.mercadobitcoin.net/api/BTC/ticker/", HttpMethod.GET, entity, String.class).getBody());
    }

    @GetMapping("/infoConta")
    public ResponseEntity infoConta() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

        ParamComum paramComum = new ParamComum("list_orders");

        String path = paramComum.buildPath();

        String tapiMac = HmacUtil.calculateHMAC(path, secret);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("TAPI-ID",identificador);
        headers.set("TAPI-MAC",tapiMac);

        HttpEntity <String> entity = new HttpEntity<>(headers);

        System.out.println("TAPI-ID: "+identificador);
        System.out.println("TAPI-MAC: "+tapiMac);
        System.out.println("path > "+urlMercadoBitcoin+path);

        return ResponseEntity.ok(restTemplate.exchange(urlMercadoBitcoin+path, HttpMethod.POST, entity, String.class).getBody());
    }
}
