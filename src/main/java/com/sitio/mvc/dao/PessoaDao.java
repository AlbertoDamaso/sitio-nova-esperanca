package com.sitio.mvc.dao;

import java.util.List;

import com.sitio.mvc.domain.Pessoa;


public interface PessoaDao {
    
	void save(Pessoa pessoa);

    void update(Pessoa pessoa);

    void delete(Long id);

    Pessoa findById(Long id);

    List<Pessoa> findAll();
    
    List<Pessoa> findByNome(String nome);

}
