package com.drogatel.api.service;

import java.util.Optional;

import com.drogatel.api.model.drogatel.DrogatelParametro;

public interface DrogatelParametroService {

	Optional<DrogatelParametro> buscarParametroPorNome(String nome);
}
