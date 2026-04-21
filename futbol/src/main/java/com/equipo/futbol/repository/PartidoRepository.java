package com.equipo.futbol.repository;


import com.equipo.futbol.model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    // Consulta 3: Total de goles marcados por un equipo en todos sus partidos
    @Query(value = """
        SELECT COALESCE(SUM(
            CASE WHEN p.equipo_local = :idEquipo THEN p.goles_local
                 WHEN p.equipo_visita = :idEquipo THEN p.goles_visita
                 ELSE 0
            END
        ), 0) AS total_goles
        FROM partido p
        WHERE p.equipo_local = :idEquipo OR p.equipo_visita = :idEquipo
        """, nativeQuery = true)
    Integer totalGolesPorEquipo(@Param("idEquipo") Integer idEquipo);

    // Consulta 4: Resultados de todos los partidos con nombres de equipos
    @Query(value = """
        SELECT
            p.id_partido,
            p.fecha,
            p.estadio,
            el.nombre AS nombre_local,
            ev.nombre AS nombre_visita,
            p.goles_local,
            p.goles_visita
        FROM partido p
        INNER JOIN equipo el ON p.equipo_local = el.id_equipo
        INNER JOIN equipo ev ON p.equipo_visita = ev.id_equipo
        ORDER BY p.fecha DESC
        """, nativeQuery = true)
    List<Object[]> findResultadosPartidos();
}