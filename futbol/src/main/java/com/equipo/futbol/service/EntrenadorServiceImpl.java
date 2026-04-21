package com.equipo.futbol.service;

import com.equipo.futbol.model.Entrenador;
import com.equipo.futbol.repository.EntrenadorRepository;
import com.equipo.futbol.service.EntrenadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntrenadorServiceImpl implements EntrenadorService {

    private final EntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    @Override
    public Optional<Entrenador> findById(Integer id) {
        return entrenadorRepository.findById(id);
    }

    @Override
    public Entrenador save(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    @Override
    public Optional<Entrenador> update(Integer id, Entrenador entrenador) {
        return entrenadorRepository.findById(id).map(e -> {
            e.setNombre(entrenador.getNombre());
            e.setEspecialidad(entrenador.getEspecialidad());
            e.setEquipo(entrenador.getEquipo());
            return entrenadorRepository.save(e);
        });
    }

    @Override
    public boolean delete(Integer id) {
        if (entrenadorRepository.existsById(id)) {
            entrenadorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}