package com.equipo.futbol.repository;

import com.equipo.futbol.model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    // Consulta 1: Obtener todos los jugadores de un equipo específico
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugador> findByIdEquipo(@Param("idEquipo") Integer idEquipo);

    // Consulta 2: Obtener jugadores que han marcado más de X goles
    @Query(value = """
        SELECT j.* FROM jugador j
        INNER JOIN estadistica_jugador ej ON j.id_jugador = ej.id_jugador
        GROUP BY j.id_jugador, j.nombre, j.posicion, j.dorsal, j.fecha_nac, j.nacionalidad, j.id_equipo
        HAVING SUM(ej.goles) > :minGoles
        """, nativeQuery = true)
    List<Jugador> findJugadoresConMasDeXGoles(@Param("minGoles") Integer minGoles);
}