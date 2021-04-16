package com.drogatel.api.client.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingDTO {

	private String clientID;
	private Integer type;
	private String primaryDocument;
	private String secondaryDocument;
	private String name;
	private String birthDate;
	private String email;
	private String gender;
	private AddressDTO address;
	private List<PhoneDTO> phones;
	private String deliveryTime;
	private BigDecimal price;
	
	
	
//	
//	"shipping": {
//		"clientID": "Client123",
//		"type": 1,
//		"primaryDocument": "12345678910",
//		"secondaryDocument": "12345678",
//		"name": "Complete Client Name",
//		"birthDate": "1990-01-10T00:00:00.000",
//		"email": "email@email.com.br",
//		"gender": "M",
//		"address": {
//			"street": "Street name example",
//			"number": "0",
//			"additionalInformation": "Additional information example",
//			"county": "County Example",
//			"city": "City Example",
//			"state": "SP",
//			"zipcode": "12345678",
//			"country": "Brasil",
//			"reference": "Address reference example"
//		},
//		"phones": [{
//			"type": 1,
//			"ddi": 55,
//			"ddd": 11,
//			"number": 33333333,
//			"extension": "1111"
//		}],
//		"deliveryTime": "2 dias úteis",
//		"price": 5.00
//	},
}
