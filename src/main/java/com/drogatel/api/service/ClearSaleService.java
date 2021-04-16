package com.drogatel.api.service;

import com.drogatel.api.client.dto.OrderDTO;

public interface ClearSaleService {

	String enviarXMLClearSale(String xml);
	
	String integrarPedidoClearSale(OrderDTO dto);
}
