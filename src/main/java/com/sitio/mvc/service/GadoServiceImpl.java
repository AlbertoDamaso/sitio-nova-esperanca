package com.sitio.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitio.mvc.dao.GadoDao;
import com.sitio.mvc.domain.Gado;

@Service @Transactional(readOnly = false)
public class GadoServiceImpl implements GadoService {
	
	@Autowired
	private GadoDao dao;

	@Override
	public void salvar(Gado gado) {
		dao.save(gado);		
	}

	@Override
	public void editar(Gado gado) {
		dao.update(gado);		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Override @Transactional(readOnly = true)
	public Gado buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Gado> buscarTodos() {
		
		return dao.findAll();
	}
}
