package com.drogatel.api.client.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String number;
	private String bin;
	private String end;
	private String ownerName;
	
//	"card": {
//		"number": "123456xxxxxx1234",
//		"hash": "12345678945612301234569874563210",
//		"bin": "123456",
//		"end": "1234",
//		"type": 1,
//		"validityDate": "02/2021",
//		"ownerName": "Owner Card Name",
//		"document": "12345678910",
//		"nsu": "12345"
//	}
   
}
