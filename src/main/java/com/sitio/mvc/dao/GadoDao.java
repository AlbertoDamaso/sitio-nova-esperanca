package com.sitio.mvc.dao;

import java.util.List;

import com.sitio.mvc.domain.Gado;

public interface GadoDao {

    void save(Gado gado);

    void update(Gado gado);

    void delete(Long id);

    Gado findById(Long id);

    List<Gado> findAll();
}
