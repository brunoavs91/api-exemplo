package com.drogatel.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.drogatel.api.client.dto.OrderDTO;
import com.drogatel.api.client.soap.ClearSaleSoapClient;
import com.drogatel.api.drogatel.enums.DrogatelParametrosEnum;
import com.drogatel.api.exception.BusinessException;
import com.drogatel.api.model.drogatel.DrogatelParametro;
import com.drogatel.api.service.ClearSaleService;
import com.drogatel.api.service.DrogatelParametroService;

@Service
public class ClearSaleServiceImpl implements ClearSaleService{
	
	@Autowired
	private ClearSaleSoapClient client;
	
	@Autowired
	private DrogatelParametroService parametroService;

	@Override
	public String enviarXMLClearSale(String request) {
		
		
		String url = parametroService.buscarParametroPorNome(DrogatelParametrosEnum.URL_WS_CLEARSALE.name())
				.map(DrogatelParametro::getValor)
				.orElseThrow(() -> new BusinessException(String.format("Parametro s% do sistema nao encontrado",
						DrogatelParametrosEnum.URL_WS_CLEARSALE.name())));

		String entityCode = parametroService
				.buscarParametroPorNome(DrogatelParametrosEnum.ENTITY_CODE_WS_CLEARSALE.name())
				.map(DrogatelParametro::getValor)
				.orElseThrow(() -> new BusinessException(String.format("Parametro %s do sistema nao encontrado",
						DrogatelParametrosEnum.ENTITY_CODE_WS_CLEARSALE.name())));

		return client.enviarXMLClearSale(request, url, entityCode);

	}

	@Override
	public String integrarPedidoClearSale(OrderDTO dto) {
		//tteste dpois colocar na classe do rest client e tirar os parametros
		String token = "695b58baf4424807b4f69475e3289335";
		String url ="https://homologacao.clearsale.com.br/api/v1/orders/";
		RestTemplate restTemplate = new RestTemplate();
		 restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		 // set headers
		    HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    headers.add("Authorization", "Bearer  695b58baf4424807b4f69475e3289335");
		   
			HttpEntity request = new HttpEntity(dto,headers);
		    
		 // send request and parse result
		    ResponseEntity<String> response = restTemplate.exchange(url ,HttpMethod.POST, request, String.class);
		    
		    if(response.getStatusCode() != HttpStatus.OK && response.getStatusCode() != HttpStatus.CREATED) {
		    	throw new BusinessException("Erro na requisicao :" + response.getStatusCode().name());
		    }

		    System.out.println(response);
		    return response.getBody();
		
	
	}

	
}
