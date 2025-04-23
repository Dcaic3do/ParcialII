package com.example.EquipoFutbol.Controller;

import com.example.EquipoFutbol.Model.EstadisticaJugador;
import com.example.EquipoFutbol.Service.EstadisticaJugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadistica")
public class EstadisticaJugadorController {
    private final EstadisticaJugadorService estadisticaJugadorService;

    public EstadisticaJugadorController(EstadisticaJugadorService estadisticaJugadorService) {
        this.estadisticaJugadorService = estadisticaJugadorService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<EstadisticaJugador> guardarEstadistica(@RequestBody EstadisticaJugador estadisticaJugador) {
        return ResponseEntity.ok(estadisticaJugadorService.guardar(estadisticaJugador));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<EstadisticaJugador>> listarEstadistica() {
        return ResponseEntity.ok(estadisticaJugadorService.listar());
    }

    @GetMapping("/listar/{id_estadistica}")
    public ResponseEntity<EstadisticaJugador> obtenerEstadisticaPorId(@PathVariable long id_estadistica) {
        return estadisticaJugadorService.listarPorId(id_estadistica)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id_estadistica}")
    public ResponseEntity<Void> eliminarEstadistica(@PathVariable long id_estadistica) {
        estadisticaJugadorService.eliminar(id_estadistica);
        return ResponseEntity.noContent().build();
    }
}
