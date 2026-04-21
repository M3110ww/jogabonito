package com.equipo.futbol.service;

import com.equipo.futbol.model.Entrenador;

import java.util.List;
import java.util.Optional;

public interface EntrenadorService {

    List<Entrenador> findAll();

    Optional<Entrenador> findById(Integer id);

    Entrenador save(Entrenador entrenador);

    Optional<Entrenador> update(Integer id, Entrenador entrenador);

    boolean delete(Integer id);
}