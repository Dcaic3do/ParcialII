package com.example.EquipoFutbol.Service;

import com.example.EquipoFutbol.Model.Entrenador;
import com.example.EquipoFutbol.Repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public Entrenador guardar(Entrenador entrenador) {
        try {
            return entrenadorRepository.save(entrenador);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la información del entrenador" + e.getMessage(), e);
        }
    }

    public List<Entrenador> listar(){
        try {
            return entrenadorRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar todos los entrenadores" + e.getMessage(), e);
        }
    }

    public void eliminar(Long id_entrenador){
        try {
            if (!entrenadorRepository.existsById(id_entrenador)) {
                throw new IllegalArgumentException("No se encontró un entrenador con el ID " + id_entrenador);
            }
            entrenadorRepository.deleteById(id_entrenador);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el entrenador" + e.getMessage(), e);
        }
    }

    public Optional<Entrenador> listarPorId(long id_entrenador) {
        try {
            Optional<Entrenador> entrenador = entrenadorRepository.findById(id_entrenador);
            if (entrenador.isEmpty()) {
                throw new IllegalArgumentException("Entrenador con ID " + id_entrenador + " no encontrado.");
            }
            return entrenador;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar entrenador por ID" + e.getMessage(), e);
        }
    }
}
