package com.equipo.futbol.service;

import com.equipo.futbol.model.Partido;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PartidoService {

    List<Partido> findAll();

    Optional<Partido> findById(Integer id);

    Partido save(Partido partido);

    Optional<Partido> update(Integer id, Partido partido);

    boolean delete(Integer id);

    // Consultas nativas
    Integer totalGolesPorEquipo(Integer idEquipo);

    List<Map<String, Object>> findResultadosPartidos();
}