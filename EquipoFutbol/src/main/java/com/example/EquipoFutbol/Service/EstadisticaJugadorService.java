package com.example.EquipoFutbol.Service;

import com.example.EquipoFutbol.Model.EstadisticaJugador;
import com.example.EquipoFutbol.Repository.EstadisticaJugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaJugadorService {
    private final EstadisticaJugadorRepository estadisticaJugadorRepository;

    public EstadisticaJugadorService(EstadisticaJugadorRepository estadisticaJugadorRepository) {
        this.estadisticaJugadorRepository = estadisticaJugadorRepository;
    }

    public EstadisticaJugador guardar(EstadisticaJugador estadisticaJugador) {
        try {
            return estadisticaJugadorRepository.save(estadisticaJugador);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la información de la estadistica del jugador" + e.getMessage(), e);
        }
    }

    public List<EstadisticaJugador> listar(){
        try {
            return estadisticaJugadorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar las estadisticas de todos los jugadores" + e.getMessage(), e);
        }
    }

    public void eliminar(Long id_estadistica){
        try {
            if (!estadisticaJugadorRepository.existsById(id_estadistica)) {
                throw new IllegalArgumentException("No se encontró una estadistica con el ID " + id_estadistica);
            }
            estadisticaJugadorRepository.deleteById(id_estadistica);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar las estadistica" + e.getMessage(), e);
        }
    }

    public Optional<EstadisticaJugador> listarPorId(long id_estadistica) {
        try {
            Optional<EstadisticaJugador> estadisticaJugador = estadisticaJugadorRepository.findById(id_estadistica);
            if (estadisticaJugador.isEmpty()) {
                throw new IllegalArgumentException("Estadistica con ID " + id_estadistica + " no encontrada.");
            }
            return estadisticaJugador;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar una estadistica por ID" + e.getMessage(), e);
        }
    }
}
