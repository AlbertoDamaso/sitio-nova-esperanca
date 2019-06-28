package com.sitio.mvc.service;

import java.util.List;
import com.sitio.mvc.domain.Fazenda;


public interface FazendaService {

	void salvar(Fazenda fazenda);
	
	void editar(Fazenda fazenda);
	
	void excluir(Long id);
	
	Fazenda buscarPorId(Long id);
	
	List<Fazenda> buscarTodos();

}