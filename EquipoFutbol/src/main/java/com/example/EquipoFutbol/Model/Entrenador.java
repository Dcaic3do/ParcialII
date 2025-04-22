package com.example.EquipoFutbol.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Entrenador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_entrenador;

    private String nombre;
    private String especialidad;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipo equipo;
}
