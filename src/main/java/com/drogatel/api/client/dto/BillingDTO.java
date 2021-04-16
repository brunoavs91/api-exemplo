package com.drogatel.api.client.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String clientID;
	private Integer type;
	private String primaryDocument;
	private String secondaryDocument;
	private String name;
	private AddressDTO address;
	private List<PhoneDTO> phones;
	
}
