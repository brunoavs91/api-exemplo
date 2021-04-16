package com.drogatel.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drogatel.api.model.drogatel.DrogatelParametro;

@Repository
public interface DrogatelParametroRepository extends JpaRepository<DrogatelParametro, Integer>{

	
	public Optional<DrogatelParametro> findByNome(String nome);
}
