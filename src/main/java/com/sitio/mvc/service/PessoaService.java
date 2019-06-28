package com.sitio.mvc.service;

import java.util.List;

import com.sitio.mvc.domain.Pessoa;

public interface PessoaService {

    void salvar(Pessoa pessoa);

    void editar(Pessoa pessoa);

    void excluir(Long id);

    Pessoa buscarPorId(Long id);

    List<Pessoa> buscarTodos();

	List<Pessoa> buscarPorNome(String nome);


}
