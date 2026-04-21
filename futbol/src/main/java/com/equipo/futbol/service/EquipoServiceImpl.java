package com.equipo.futbol.service;

import com.equipo.futbol.model.Equipo;
import com.equipo.futbol.repository.EquipoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipoServiceImpl implements EquipoService {

    private final EquipoRepository equipoRepository;

    @Override
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @Override
    public Optional<Equipo> findById(Integer id) {
        return equipoRepository.findById(id);
    }

    @Override
    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    @Override
    public Optional<Equipo> update(Integer id, Equipo equipo) {
        return equipoRepository.findById(id).map(e -> {
            e.setNombre(equipo.getNombre());
            e.setCiudad(equipo.getCiudad());
            e.setFundacion(equipo.getFundacion());
            return equipoRepository.save(e);
        });
    }

    @Override
    public boolean delete(Integer id) {
        if (equipoRepository.existsById(id)) {
            equipoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}