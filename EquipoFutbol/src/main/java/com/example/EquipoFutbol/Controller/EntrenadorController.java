package com.example.EquipoFutbol.Controller;

import com.example.EquipoFutbol.Model.Entrenador;
import com.example.EquipoFutbol.Service.EntrenadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenador")
public class EntrenadorController {
    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Entrenador> guardarEntrenador(@RequestBody Entrenador entrenador) {
        return ResponseEntity.ok(entrenadorService.guardar(entrenador));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Entrenador>> listarEntrenador() {
        return ResponseEntity.ok(entrenadorService.listar());
    }

    @GetMapping("/listar/{id_entrenador}")
    public ResponseEntity<Entrenador> obtenerEntrenadorPorId(@PathVariable long id_entrenador) {
        return entrenadorService.listarPorId(id_entrenador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id_entrenador}")
    public ResponseEntity<Void> eliminarEntrenador(@PathVariable long id_entrenador) {
        entrenadorService.eliminar(id_entrenador);
        return ResponseEntity.noContent().build();
    }
}
