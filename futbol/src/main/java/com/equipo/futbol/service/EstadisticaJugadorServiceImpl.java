package com.equipo.futbol.service;

import com.equipo.futbol.model.EstadisticaJugador;
import com.equipo.futbol.repository.EstadisticaJugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstadisticaJugadorServiceImpl implements EstadisticaJugadorService {

    private final EstadisticaJugadorRepository estadisticaRepository;

    @Override
    public List<EstadisticaJugador> findAll() {
        return estadisticaRepository.findAll();
    }

    @Override
    public Optional<EstadisticaJugador> findById(Integer id) {
        return estadisticaRepository.findById(id);
    }

    @Override
    public EstadisticaJugador save(EstadisticaJugador estadistica) {
        return estadisticaRepository.save(estadistica);
    }

    @Override
    public Optional<EstadisticaJugador> update(Integer id, EstadisticaJugador estadistica) {
        return estadisticaRepository.findById(id).map(e -> {
            e.setJugador(estadistica.getJugador());
            e.setPartido(estadistica.getPartido());
            e.setMinutosJugados(estadistica.getMinutosJugados());
            e.setGoles(estadistica.getGoles());
            e.setAsistencias(estadistica.getAsistencias());
            e.setTarjetasAmarillas(estadistica.getTarjetasAmarillas());
            e.setTarjetasRojas(estadistica.getTarjetasRojas());
            return estadisticaRepository.save(e);
        });
    }

    @Override
    public boolean delete(Integer id) {
        if (estadisticaRepository.existsById(id)) {
            estadisticaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}