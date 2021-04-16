package com.drogatel.api.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drogatel.api.model.drogatel.DrogatelParametro;
import com.drogatel.api.repository.DrogatelParametroRepository;
import com.drogatel.api.service.DrogatelParametroService;

@Service
public class DrogatelParametroServiceImpl implements DrogatelParametroService{

	@Autowired
	private DrogatelParametroRepository repository;

	@Override
	public Optional<DrogatelParametro> buscarParametroPorNome(String nome) {
		
		return repository.findByNome(nome);
	}

	
	
	
}
