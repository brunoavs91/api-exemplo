package com.drogatel.api.client.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String street;
	private String number;
	private String additionalInformation;
	private String county;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private String reference;
	
//	
//	"street": "Street name example",
//	"number": "0",
//	"additionalInformation": "Additional information example",
//	"county": "County Example",
//	"city": "City Example",
//	"state": "SP",
//	"zipcode": "12345678",
//	"country": "Brasil",
//	"reference": "Address reference example"
}
