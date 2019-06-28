package com.sitio.mvc.service;

import java.util.List;

import com.sitio.mvc.domain.Vacasp;

public interface VacaspService {

    void salvar(Vacasp vacasp);

    void editar(Vacasp vacasp);

    void excluir(Long id);

    Vacasp buscarPorId(Long id);
    
    List<Vacasp> buscarTodos();

	boolean vacaspTemGados(Long id);
}
