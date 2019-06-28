package com.sitio.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sitio.mvc.domain.Pessoa;

@Repository
public class PessoaDaoImpl extends AbstractDao<Pessoa, Long> implements PessoaDao {

	public List<Pessoa> findByNome(String nome) {
		
		return createQuery("select f from Pessoa f where f.nome like concat('%',?1,'%') ", nome);
	}

	
}
