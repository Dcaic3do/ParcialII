package com.example.EquipoFutbol.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_partido;

    private Date fecha;
    private String estadio;

    @ManyToOne
    @JoinColumn(name = "equipo_local", nullable = false)
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante", nullable = false)
    private Equipo equipoVisitante;

    private int goles_local;
    private int goles_visitante;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<EstadisticaJugador> estadisticaJugadores;
}
