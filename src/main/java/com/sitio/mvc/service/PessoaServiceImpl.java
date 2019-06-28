package com.sitio.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitio.mvc.dao.PessoaDao;
import com.sitio.mvc.domain.Pessoa;

@Service
@Transactional(readOnly = true)
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Pessoa pessoa) {
		dao.save(pessoa);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Pessoa pessoa) {
		dao.update(pessoa);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Pessoa buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Pessoa> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public List<Pessoa> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}


}
