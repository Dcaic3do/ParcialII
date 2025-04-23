package com.example.EquipoFutbol.Controller;

import com.example.EquipoFutbol.Model.Partido;
import com.example.EquipoFutbol.Service.PartidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partido")
public class PartidoController {
    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Partido> guardarPartido(@RequestBody Partido partido) {
        return ResponseEntity.ok(partidoService.guardar(partido));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Partido>> listarPartido() {
        return ResponseEntity.ok(partidoService.listar());
    }

    @GetMapping("/listar/{id_partido}")
    public ResponseEntity<Partido> obtenerPartidoPorId(@PathVariable long id_partido) {
        return partidoService.listarPorId(id_partido)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id_partido}")
    public ResponseEntity<Void> eliminarPartido(@PathVariable long id_partido) {
        partidoService.eliminar(id_partido);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/goles_por partido/{id_equipo}")
    public int getGolesTotalesEquipo(@PathVariable Long id_equipo) {
        return partidoService.listarTotalGolesEquipo(id_equipo);
    }
}
