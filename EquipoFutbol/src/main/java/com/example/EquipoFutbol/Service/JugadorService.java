package com.example.EquipoFutbol.Service;

import com.example.EquipoFutbol.Model.Jugador;
import com.example.EquipoFutbol.Repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public Jugador guardar(Jugador jugador) {
        try {
            return jugadorRepository.save(jugador);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la información del jugador" + e.getMessage(), e);
        }
    }

    public List<Jugador> listar(){
        try {
            return jugadorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar todos los jugadores" + e.getMessage(), e);
        }
    }

    public void eliminar(Long id_jugador){
        try {
            if (!jugadorRepository.existsById(id_jugador)) {
                throw new IllegalArgumentException("No se encontró un jugador con el ID " + id_jugador);
            }
            jugadorRepository.deleteById(id_jugador);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el jugador" + e.getMessage(), e);
        }
    }

    public Optional<Jugador> listarPorId(long id_jugador) {
        try {
            Optional<Jugador> jugador = jugadorRepository.findById(id_jugador);
            if (jugador.isEmpty()) {
                throw new IllegalArgumentException("Jugador con ID " + id_jugador + " no encontrado.");
            }
            return jugador;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar jugador por ID" + e.getMessage(), e);
        }
    }
}
