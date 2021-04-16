package com.drogatel.api.client.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String name;
	private BigDecimal value;
	private Integer amount;
}
