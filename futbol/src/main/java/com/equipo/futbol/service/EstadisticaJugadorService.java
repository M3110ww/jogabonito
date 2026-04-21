package com.equipo.futbol.service;

import com.equipo.futbol.model.EstadisticaJugador;

import java.util.List;
import java.util.Optional;

public interface EstadisticaJugadorService {

    List<EstadisticaJugador> findAll();

    Optional<EstadisticaJugador> findById(Integer id);

    EstadisticaJugador save(EstadisticaJugador estadistica);

    Optional<EstadisticaJugador> update(Integer id, EstadisticaJugador estadistica);

    boolean delete(Integer id);
}