package com.drogatel.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drogatel.api.client.dto.OrderDTO;
import com.drogatel.api.service.ClearSaleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/clear-sale/")
@Api(value="API REST drogatel Clear sale")
@CrossOrigin(origins = "*")
public class ClearSaleController {

	
	@Autowired
	private ClearSaleService service;
	

	@PostMapping("integrar-pedido")
	@ApiOperation(value = "Envia xml para clear sale")
	public ResponseEntity enviarXMLClearSale(@RequestBody String request) {
		
		System.out.println("Testando api CLEARSALE");

		return ResponseEntity.ok(service.enviarXMLClearSale(request));
	}
	
	@PostMapping("integrar-pedido-rest")
	@ApiOperation(value = "Integra o pedido do drogatel na clear sale")
	public ResponseEntity integrarPedidoClearSale(@RequestBody OrderDTO order) throws JsonMappingException, JsonProcessingException {
//		
//		ObjectMapper mapper = new ObjectMapper();
//		OrderDTO order = mapper.readValue(dto, OrderDTO.class);
		
		System.out.println("Testando api CLEARSALE");

		return ResponseEntity.ok(service.integrarPedidoClearSale(order));
	}
}
