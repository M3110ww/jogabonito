package com.equipo.futbol.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "partido")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Integer idPartido;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estadio", length = 100)
    private String estadio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_local", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_visita", nullable = false)
    private Equipo equipoVisita;

    @Column(name = "goles_local")
    private Integer golesLocal;

    @Column(name = "goles_visita")
    private Integer golesVisita;
}