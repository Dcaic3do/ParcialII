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
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_equipo;

    private String nombre;
    private String ciudad;
    private Date fundacion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Entrenador> entrenadores;

    @OneToMany(mappedBy = "equipoLocal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Partido> partidosLocal;

    @OneToMany(mappedBy = "equipoVisitante", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Partido> partidosVisitante;
}
