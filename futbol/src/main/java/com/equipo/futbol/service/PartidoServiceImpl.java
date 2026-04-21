package com.equipo.futbol.service;

import com.equipo.futbol.model.Partido;
import com.equipo.futbol.repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PartidoServiceImpl implements PartidoService {

    private final PartidoRepository partidoRepository;

    @Override
    public List<Partido> findAll() {
        return partidoRepository.findAll();
    }

    @Override
    public Optional<Partido> findById(Integer id) {
        return partidoRepository.findById(id);
    }

    @Override
    public Partido save(Partido partido) {
        return partidoRepository.save(partido);
    }

    @Override
    public Optional<Partido> update(Integer id, Partido partido) {
        return partidoRepository.findById(id).map(p -> {
            p.setFecha(partido.getFecha());
            p.setEstadio(partido.getEstadio());
            p.setEquipoLocal(partido.getEquipoLocal());
            p.setEquipoVisita(partido.getEquipoVisita());
            p.setGolesLocal(partido.getGolesLocal());
            p.setGolesVisita(partido.getGolesVisita());
            return partidoRepository.save(p);
        });
    }

    @Override
    public boolean delete(Integer id) {
        if (partidoRepository.existsById(id)) {
            partidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Integer totalGolesPorEquipo(Integer idEquipo) {
        return partidoRepository.totalGolesPorEquipo(idEquipo);
    }

    @Override
    public List<Map<String, Object>> findResultadosPartidos() {
        List<Object[]> rows = partidoRepository.findResultadosPartidos();
        List<Map<String, Object>> result = new ArrayList<>();
        for (Object[] row : rows) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id_partido",    row[0]);
            map.put("fecha",         row[1]);
            map.put("estadio",       row[2]);
            map.put("nombre_local",  row[3]);
            map.put("nombre_visita", row[4]);
            map.put("goles_local",   row[5]);
            map.put("goles_visita",  row[6]);
            result.add(map);
        }
        return result;
    }
}