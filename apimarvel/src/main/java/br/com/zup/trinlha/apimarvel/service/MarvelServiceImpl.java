package br.com.zup.trinlha.apimarvel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.zup.trinlha.apimarvel.model.GeneralResponse;

@Service
public class MarvelServiceImpl {
	
	@Value("${url.postmon}")
	private String url;
	
	public GeneralResponse consumer(String hash) {
		String fullUrl = url + hash;
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(fullUrl, GeneralResponse.class);
	}

}
