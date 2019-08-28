package br.com.bitcoin.robo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class RoboApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoboApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
