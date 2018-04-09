package br.com.raphael.javaclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {
	@Bean
	public RestOperations createRestTemplate(final ClientHttpRequestFactory clientRequestFactory) {
		return new RestTemplate(clientRequestFactory);
	}
	@Bean
	public ClientHttpRequestFactory createClientHttpRequestFactory(@Value("${connect.timeout}") final int connectTimeout, @Value("${read.timeout}") int readTimeout) {
		HttpComponentsClientHttpRequestFactory hccr =	new HttpComponentsClientHttpRequestFactory();
		hccr.setReadTimeout(readTimeout);
		hccr.setConnectTimeout(connectTimeout);
		return hccr;
	}
}
