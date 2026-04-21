package com.equipo.futbol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estadistica_jugador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticaJugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private Integer idEstadistica;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_jugador", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_partido", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Partido partido;

    @Column(name = "minutos_jugados")
    private Integer minutosJugados;

    @Column(name = "goles")
    private Integer goles;

    @Column(name = "asistencias")
    private Integer asistencias;

    @Column(name = "tarjetas_amarillas")
    private Integer tarjetasAmarillas;

    @Column(name = "tarjetas_rojas")
    private Integer tarjetasRojas;
}