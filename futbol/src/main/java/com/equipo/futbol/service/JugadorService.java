package com.equipo.futbol.service;

import com.equipo.futbol.model.Jugador;

import java.util.List;
import java.util.Optional;

public interface JugadorService {

    List<Jugador> findAll();

    Optional<Jugador> findById(Integer id);

    Jugador save(Jugador jugador);

    Optional<Jugador> update(Integer id, Jugador jugador);

    boolean delete(Integer id);

    // Consultas nativas
    List<Jugador> findByEquipo(Integer idEquipo);

    List<Jugador> findJugadoresConMasDeXGoles(Integer minGoles);
}