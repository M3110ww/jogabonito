package com.equipo.futbol.controller;

import com.equipo.futbol.model.Partido;
import com.equipo.futbol.service.PartidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/partidos")
@RequiredArgsConstructor
@Tag(name = "Partidos", description = "CRUD de partidos y consultas nativas")
public class PartidoController {

    private final PartidoService partidoService;

    @GetMapping
    @Operation(summary = "Listar todos los partidos")
    public List<Partido> getAll() {
        return partidoService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener partido por ID")
    public ResponseEntity<Partido> getById(@PathVariable Integer id) {
        return partidoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo partido")
    public Partido create(@RequestBody Partido partido) {
        return partidoService.save(partido);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar partido")
    public ResponseEntity<Partido> update(@PathVariable Integer id, @RequestBody Partido partido) {
        return partidoService.update(id, partido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar partido")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return partidoService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // ─── Consultas nativas ───────────────────────────────────────────────────

    @GetMapping("/goles-equipo/{idEquipo}")
    @Operation(summary = "Consulta 3: Total de goles de un equipo en todos sus partidos")
    public ResponseEntity<Map<String, Object>> getTotalGolesPorEquipo(@PathVariable Integer idEquipo) {
        Integer total = partidoService.totalGolesPorEquipo(idEquipo);
        return ResponseEntity.ok(Map.of("id_equipo", idEquipo, "total_goles", total));
    }

    @GetMapping("/resultados")
    @Operation(summary = "Consulta 4: Resultados de todos los partidos con nombres de equipos")
    public List<Map<String, Object>> getResultados() {
        return partidoService.findResultadosPartidos();
    }
}