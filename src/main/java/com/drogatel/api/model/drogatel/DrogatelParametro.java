package com.drogatel.api.model.drogatel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name="DROGATEL_INI")
public class DrogatelParametro extends BaseEntity{

	
	private static final long serialVersionUID = 1L;

	
	
	@Id
	@Column(name="DRIN_TX_ENTRADA")
    private String nome;

	@Column(name="DRIN_TX_VALOR")
	private String valor;
	
	@Column(name="DRIN_TX_OBSERVACAO")
	private String observacao;
	

	public DrogatelParametro(String codigoUsuario) {
		super(codigoUsuario);
		
	}
	
	

}
