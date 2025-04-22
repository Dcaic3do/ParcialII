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
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_jugador;

    private String nombre;
    private String Posicion;
    private int dorsal;
    private Date fecha_nac;
    private String nacionalidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<EstadisticaJugador> estadisticaJugadores;

}
