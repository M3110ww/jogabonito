package com.equipo.futbol.controller;

import com.equipo.futbol.model.Entrenador;
import com.equipo.futbol.service.EntrenadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entrenadores")
@RequiredArgsConstructor
@Tag(name = "Entrenadores", description = "CRUD de entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    @GetMapping
    @Operation(summary = "Listar todos los entrenadores")
    public List<Entrenador> getAll() {
        return entrenadorService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener entrenador por ID")
    public ResponseEntity<Entrenador> getById(@PathVariable Integer id) {
        return entrenadorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Crear nuevo entrenador")
    public Entrenador create(@RequestBody Entrenador entrenador) {
        return entrenadorService.save(entrenador);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar entrenador")
    public ResponseEntity<Entrenador> update(@PathVariable Integer id, @RequestBody Entrenador entrenador) {
        return entrenadorService.update(id, entrenador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar entrenador")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        return entrenadorService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}