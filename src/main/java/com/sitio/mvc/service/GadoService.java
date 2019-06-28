package com.sitio.mvc.service;

import java.util.List;

import com.sitio.mvc.domain.Gado;

public interface GadoService {

	void salvar(Gado gado);
	
	void editar(Gado gado);
	
	void excluir(Long id);
	
	Gado buscarPorId(Long id);
	
	List<Gado> buscarTodos();
	
}
