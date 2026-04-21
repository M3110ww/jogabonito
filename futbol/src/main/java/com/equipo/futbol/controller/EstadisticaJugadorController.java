package com.equipo.futbol.controller;

import com.equipo.futbol.model.EstadisticaJugador;
import com.equipo.futbol.service.EstadisticaJugadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estadisticas")
@RequiredArgsConstructor
@Tag(name = "Estadísticas", description = "CRUD de estadísticas de jugadores por partido")
public class EstadisticaJugadorController {

    private final EstadisticaJugadorService estadisticaService;

    @GetMapping
    @Operation(summary = "Listar todas las estadísticas")
    public List<EstadisticaJugador> getAll() {
        return estadisticaService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener estadística por ID")
    public ResponseEntity<EstadisticaJugador> getById(@PathVariable Integer id) {
        return estadisticaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Registrar estadística de jugador en partido")
    public EstadisticaJugador create(@RequestBody EstadisticaJugador estadistica) {
        return estadisticaService.save(estadistica);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar estadística")
    public ResponseEntity<EstadisticaJugador> update(@PathVariable Integer id,
                                                     @RequestBody EstadisticaJugador estadistica) {
        return estadisticaService.update(id, estadistica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar estadística")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return estadisticaService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}