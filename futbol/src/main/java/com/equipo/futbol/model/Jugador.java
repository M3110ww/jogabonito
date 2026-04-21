package com.equipo.futbol.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "jugador")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Integer idJugador;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "posicion", length = 50)
    private String posicion;

    @Column(name = "dorsal")
    private Integer dorsal;

    @Column(name = "fecha_nac")
    private LocalDate fechaNac;

    @Column(name = "nacionalidad", length = 100)
    private String nacionalidad;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Equipo equipo;
}