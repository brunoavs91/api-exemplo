package com.drogatel.api.client.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	private String code;
	private String sessionID;
	private String date;
	private String email;
	private String b2bB2c;
	private Double itemValue;
	private Double totalValue;
	private Integer numberOfInstallments;
	private String ip;
	private String giftMessage;
	private String observation;
	private Integer status;
	private String origin;
	private String channelID;
	private String reservationDate;
	private Integer product;
	private BillingDTO billing;
	private ShippingDTO shipping;
	private List<PaymentDTO> payments;
	private List<ItemDTO> items;
	private List<PassengerDTO> passengers;
	private List<ConnectionDTO> connections;
}
