package com.sitio.mvc.dao;

import java.util.List;

import com.sitio.mvc.domain.Vacasp;

public interface VacaspDao {

    void save(Vacasp vacasp);

    void update(Vacasp vacasp);

    void delete(Long id);

    Vacasp findById(Long id);

    List<Vacasp> findAll();
}
