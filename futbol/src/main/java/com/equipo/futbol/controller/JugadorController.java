package com.equipo.futbol.controller;

import com.equipo.futbol.model.Jugador;
import com.equipo.futbol.service.JugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
@Tag(name = "Jugadores", description = "CRUD de jugadores y consultas nativas")
public class JugadorController {

    private final JugadorService jugadorService;

    @GetMapping
    @Operation(summary = "Listar todos los jugadores")
    public List<Jugador> getAll() {
        return jugadorService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener jugador por ID")
    public ResponseEntity<Jugador> getById(@PathVariable Integer id) {
        return jugadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo jugador")
    public Jugador create(@RequestBody Jugador jugador) {
        return jugadorService.save(jugador);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar jugador")
    public ResponseEntity<Jugador> update(@PathVariable Integer id, @RequestBody Jugador jugador) {
        return jugadorService.update(id, jugador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar jugador")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return jugadorService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // ─── Consultas nativas ───────────────────────────────────────────────────

    @GetMapping("/equipo/{idEquipo}")
    @Operation(summary = "Consulta 1: Jugadores de un equipo específico")
    public List<Jugador> getByEquipo(@PathVariable Integer idEquipo) {
        return jugadorService.findByEquipo(idEquipo);
    }

    @GetMapping("/goles-mayor/{minGoles}")
    @Operation(summary = "Consulta 2: Jugadores con más de X goles en total")
    public List<Jugador> getJugadoresConMasGoles(@PathVariable Integer minGoles) {
        return jugadorService.findJugadoresConMasDeXGoles(minGoles);
    }
}