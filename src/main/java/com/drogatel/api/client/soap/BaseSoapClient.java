package com.drogatel.api.client.soap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.drogatel.api.drogatel.enums.DrogatelParametrosEnum;
import com.drogatel.api.exception.BusinessException;

import javassist.bytecode.stackmap.TypeData.ClassName;

@Component
public class BaseSoapClient {
	
	private static final Logger LOGGER = Logger.getLogger( ClassName.class.getName() );
	
	
	
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
		
		return response.getBody();
	}
	
	
	
	public String novaImplmentacao(String xml, String urlClearSale) {
		 String wsURL = urlClearSale;
	        URL url = null;
	        URLConnection connection = null;
	        HttpURLConnection httpConn = null;
	        String responseString = null;
	        String outputString="";
	        OutputStream out = null;
	        InputStreamReader isr = null;
	        BufferedReader in = null;
	        
	        try {
	        	
	        	  url = new URL(wsURL);
	              connection = url.openConnection();
	              httpConn = (HttpURLConnection) connection;
	   
	              byte[] buffer = new byte[xml.length()];
	              buffer = xml.getBytes();
	              
	              String SOAPAction = "http://www.clearsale.com.br/integration/SendOrders";
	              // Set the appropriate HTTP parameters.
	               httpConn.setRequestProperty("Content-Length", String
	                       .valueOf(buffer.length));
	              httpConn.setRequestProperty("Content-Type",
	                      "text/xml; charset=utf-8");
	              
	               
	              httpConn.setRequestProperty("SOAPAction", SOAPAction);
	              httpConn.setRequestProperty("entityCode", "B88CC985-5689-43F2-B174-C8B543B5A3DB");
	              httpConn.setRequestMethod("POST");
	              httpConn.setDoOutput(true);
	              httpConn.setDoInput(true);
	              httpConn.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; "
	                      + "Windows NT 5.1; en-US; rv:1.8.0.11) ");
	              
	              out = httpConn.getOutputStream();
	              out.write(buffer);
	              out.close();
	              
	              
	              // Read the response and write it to standard out.
	              isr = new InputStreamReader(httpConn.getInputStream());
	              in = new BufferedReader(isr);
	               
	              while ((responseString = in.readLine()) != null) 
	              {
	                  outputString = outputString + responseString;
	              }
	              System.out.println(outputString);
	              System.out.println("");
	               
	              // Get the response from the web service call
	              Document document = parseXmlFile(outputString);
	               
	              NodeList nodeLst = document.getElementsByTagName("int:SendOrders");
	              String webServiceResponse = nodeLst.item(0).getTextContent();
	              System.out.println("The response from the web service call is : " + webServiceResponse);
	        	return webServiceResponse;
	        }catch (Exception e) {
				throw new BusinessException(e.getMessage(),e.getCause());
			}
	}
	
	 private Document parseXmlFile(String in) {
	        try {
	            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	            DocumentBuilder db = dbf.newDocumentBuilder();
	             InputSource is = new InputSource(new StringReader(in));
	            return db.parse(is);
	        } catch (ParserConfigurationException e) {
	            throw new RuntimeException(e);
	        } catch (SAXException e) {
	            throw new RuntimeException(e);
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
