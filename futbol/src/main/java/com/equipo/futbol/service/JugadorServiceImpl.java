package com.equipo.futbol.service;

import com.equipo.futbol.model.Jugador;
import com.equipo.futbol.repository.JugadorRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository jugadorRepository;

    @Override
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @Override
    public Optional<Jugador> findById(Integer id) {
        return jugadorRepository.findById(id);
    }

    @Override
    public Jugador save(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @Override
    public Optional<Jugador> update(Integer id, Jugador jugador) {
        return jugadorRepository.findById(id).map(j -> {
            j.setNombre(jugador.getNombre());
            j.setPosicion(jugador.getPosicion());
            j.setDorsal(jugador.getDorsal());
            j.setFechaNac(jugador.getFechaNac());
            j.setNacionalidad(jugador.getNacionalidad());
            j.setEquipo(jugador.getEquipo());
            return jugadorRepository.save(j);
        });
    }

    @Override
    public boolean delete(Integer id) {
        if (jugadorRepository.existsById(id)) {
            jugadorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Jugador> findByEquipo(Integer idEquipo) {
        return jugadorRepository.findByIdEquipo(idEquipo);
    }

    @Override
    public List<Jugador> findJugadoresConMasDeXGoles(Integer minGoles) {
        return jugadorRepository.findJugadoresConMasDeXGoles(minGoles);
    }
}