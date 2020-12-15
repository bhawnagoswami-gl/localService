package com.ac.documentmanagement.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import com.amazonaws.xray.proxies.apache.http.HttpClientBuilder;

@Configuration
public class DocManagementConfiguration {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate(clientHttpRequestFactory());
	}
	
	private ClientHttpRequestFactory clientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(
						HttpClientBuilder.create().useSystemProperties().build());
		factory.setReadTimeout(10000);
		factory.setConnectTimeout(2000);
		factory.setConnectionRequestTimeout(2000);
		return factory;
	}
	
	
}
