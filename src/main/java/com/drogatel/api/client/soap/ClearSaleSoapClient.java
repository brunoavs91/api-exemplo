package com.drogatel.api.client.soap;

import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.drogatel.api.exception.BusinessException;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Component
public class ClearSaleSoapClient {

	
	private static final Logger LOGGER = Logger.getLogger( ClassName.class.getName() );
	private String SEND_ORDERS= "/SendOrders";
	

	
	public String enviarXMLClearSale(String request, String url, String entityCode) {
//		//passar valores de paramentros
		String urlOrders= url+SEND_ORDERS;
		List<String> listaParametros = Arrays.asList(entityCode, request);
		String xmlClearSale = preencherXMLClearSale( listaParametros);
		MultiValueMap<String, String> parametros= new LinkedMultiValueMap<String, String>();
		parametros.add("entityCode", entityCode);
		parametros.add("xml", xmlClearSale);
		
		//parametros.entrySet().stream().collect(Collectors.toList()).get(0);
		
		
		return chamadaWebServiceSoap(urlOrders, parametros);
	}

	private String preencherXMLClearSale(List<String> parametros) {
		int cont = 0;
		String xmlPadraoClearSale = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\r\n"
				+ "  <soap:Body>\r\n"
				+ "    <SendOrders xmlns=\"http://www.clearsale.com.br/integration\">\r\n"
				+ "      <entityCode>*</entityCode>\r\n"
				+ "      <xml>*</xml>\r\n"
				+ "    </SendOrders>\r\n"
				+ "  </soap:Body>\r\n"
				+ "</soap:Envelope>";

		if(CollectionUtils.isEmpty(parametros)) {
			throw new BusinessException("Nao ha parametros para preencher o XML clearSale");
		}
		for (int i = 0; i < xmlPadraoClearSale.length(); i++) {
			if ("*".equals(String.valueOf(xmlPadraoClearSale.charAt(i)))) {

				xmlPadraoClearSale = xmlPadraoClearSale
						.replaceFirst(String.valueOf("[" + xmlPadraoClearSale.charAt(i) + "]"), parametros.get(cont));
				cont++;
			}
		}
		return xmlPadraoClearSale;
	}
	
	
	public String chamadaWebServiceSoap(String url, MultiValueMap<String, String> parametros ) {
		LOGGER.info("Iniciando requisicao...");
		
		RestTemplate restTemplate = new RestTemplate(); 
		restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		HttpEntity entity = new HttpEntity(parametros, headers);
		
		ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
		
		if(response.getStatusCode() != HttpStatus.OK && response.getStatusCode() != HttpStatus.CREATED) {
			throw new BusinessException("Erro na requisicao :" + response.getStatusCode().name());
		}
		
		System.out.println("Status da requisicao :" + response.getStatusCodeValue());
		
		return response.getBody();
	}
}
