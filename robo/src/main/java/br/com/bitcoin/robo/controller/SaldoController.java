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

//        Métodos da API
//                ticker
//        Descrição
//        Retorna informações com o resumo das últimas 24 horas de negociações.
//
//                Resultado
//        high: Maior preço unitário de negociação das últimas 24 horas.
//                Tipo: Decimal
//        low: Menor preço unitário de negociação das últimas 24 horas.
//                Tipo: Decimal
//        vol: Quantidade negociada nas últimas 24 horas.
//                Tipo: Decimal
//        last: Preço unitário da última negociação.
//                Tipo: Decimal
//        buy: Maior preço de oferta de compra das últimas 24 horas.
//                Tipo: Decimal
//        sell: Menor preço de oferta de venda das últimas 24 horas.
//                Tipo: Decimal
//        date: Data e hora da informação em Era Unix
//        Tipo: Inteiro

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);


        return ResponseEntity.ok(restTemplate.exchange("https://www.mercadobitcoin.net/api/BTC/ticker/", HttpMethod.GET, entity, String.class).getBody());
    }

    @GetMapping("/infoConta")
    public ResponseEntity infoConta() throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {

        ParamComum paramComum = new ParamComum("list_orders", "1");

        String path = urlMercadoBitcoin+paramComum.buildFormatado();

        String signature = HmacUtil.calculateHMAC(path.toString(),secret);

        HttpHeaders headers = new HttpHeaders();

//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity <String> entity = new HttpEntity<String>(headers);

        headers.add("Content-Type", "application/x-www-form-urlencoded");
        headers.add("TAPI-ID",identificador);
        headers.add("TAPI-MAC",signature);

        return ResponseEntity.ok(restTemplate.exchange(urlMercadoBitcoin+paramComum.buildFormatado(), HttpMethod.POST, entity, String.class).getBody());
    }
}
