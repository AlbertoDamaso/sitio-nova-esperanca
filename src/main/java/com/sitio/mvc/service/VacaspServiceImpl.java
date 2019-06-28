package com.sitio.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sitio.mvc.dao.VacaspDao;
import com.sitio.mvc.domain.Vacasp;

@Service
public class VacaspServiceImpl implements VacaspService {
	
	@Autowired
	private VacaspDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Vacasp vacasp) {
		dao.save(vacasp);		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Vacasp vacasp) {
		dao.update(vacasp);		
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);		
	}

	@Transactional(readOnly = true)
	@Override
	public Vacasp buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Vacasp> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean vacaspTemGados(Long id) {
		if (buscarPorId(id).getGado().isEmpty()) {
			return false;
		}
		return true;
	}

}
