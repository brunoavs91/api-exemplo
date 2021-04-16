package com.drogatel.api.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Integer sequential;
	private String date;
	private BigDecimal value;
	private Integer type;
	private Integer installments;
	private CardDTO card;
	
//	
//	"sequential": 1,
//	"date": "2017-03-21T22:36:53.0000000",
//	"value": 0.00,
//	"type": 1,
//	"installments": 1,
//	"card": {
}
