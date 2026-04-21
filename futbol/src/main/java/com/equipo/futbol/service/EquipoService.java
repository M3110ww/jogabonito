package com.equipo.futbol.service;

import com.equipo.futbol.model.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {

    List<Equipo> findAll();

    Optional<Equipo> findById(Integer id);

    Equipo save(Equipo equipo);

    Optional<Equipo> update(Integer id, Equipo equipo);

    boolean delete(Integer id);
}