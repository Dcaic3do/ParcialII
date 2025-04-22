package com.example.EquipoFutbol.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EstadisticaJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_estadistica;

    @ManyToOne
    @JoinColumn(name = "id_jugador", nullable = false)
    private Jugador jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido", nullable = false)
    private Partido partido;

    private int minutos_jugados;
    private int goles;
    private int asistencias;
    private int tarjetas_amarillas;
    private int tarjetas_rojas;
}
