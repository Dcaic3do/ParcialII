package com.example.EquipoFutbol.Service;

import com.example.EquipoFutbol.Model.Partido;
import com.example.EquipoFutbol.Repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido guardar(Partido partido) {
        try {
            return partidoRepository.save(partido);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la información del partido" + e.getMessage(), e);
        }
    }

    public List<Partido> listar(){
        try {
            return partidoRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error al listar los partidos" + e.getMessage(), e);
        }
    }

    public void eliminar(Long id_partido){
        try {
            if (!partidoRepository.existsById(id_partido)) {
                throw new IllegalArgumentException("No se encontró un partido con el ID " + id_partido);
            }
            partidoRepository.deleteById(id_partido);
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar el partido" + e.getMessage(), e);
        }
    }

    public Optional<Partido> listarPorId(long id_partido) {
        try {
            Optional<Partido> venta = partidoRepository.findById(id_partido);
            if (venta.isEmpty()) {
                throw new IllegalArgumentException("Partido con ID " + id_partido + " no encontrado.");
            }
            return venta;
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar partido por ID" + e.getMessage(), e);
        }
    }
}
