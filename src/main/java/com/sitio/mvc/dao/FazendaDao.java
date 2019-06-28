package com.sitio.mvc.dao;

import java.util.List;

import com.sitio.mvc.domain.Fazenda;


public interface FazendaDao {

	void save(Fazenda fazenda);
	
	void update(Fazenda fazenda);

    void delete(Long id);

    Fazenda findById(Long id);

    List<Fazenda> findAll();
    
}