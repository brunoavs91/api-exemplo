package com.drogatel.api.client.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO implements Serializable {


	 
	private static final long serialVersionUID = 1L;
	
	private Integer type;
	private Integer ddi;
	private Integer ddd;
	private Integer number;
	private String extension;
	
	
//	"type": 1,
//	"ddi": 55,
//	"ddd": 11,
//	"number": 33333333,
//	"extension": "1111"
}
