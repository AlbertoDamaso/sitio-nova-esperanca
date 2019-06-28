package com.sitio.mvc.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitio.mvc.dao.FazendaDao;
import com.sitio.mvc.domain.Fazenda;

@Service 
@Transactional(readOnly = false)
public class FazendaServiceImpl implements FazendaService {
	
	@Autowired
	private FazendaDao dao;

	@Override
	public void salvar(Fazenda fazenda) {
		dao.save(fazenda);		
	}

	@Override
	public void editar(Fazenda fazenda) {
		dao.update(fazenda);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Fazenda buscarPorId(Long id) {
		
		return dao.findById(id);
	}
	
	@Override @Transactional(readOnly = true)
	public List<Fazenda> buscarTodos() {
		
		return dao.findAll();
	}
}