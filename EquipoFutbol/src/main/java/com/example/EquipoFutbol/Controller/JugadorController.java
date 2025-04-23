package com.example.EquipoFutbol.Controller;

import com.example.EquipoFutbol.Model.Jugador;
import com.example.EquipoFutbol.Service.JugadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugador")
public class JugadorController {
    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Jugador> guardarJugador(@RequestBody Jugador jugador) {
        return ResponseEntity.ok(jugadorService.guardar(jugador));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Jugador>> listarJugador() {
        return ResponseEntity.ok(jugadorService.listar());
    }

    @GetMapping("/listar/{id_jugador}")
    public ResponseEntity<Jugador> obtenerJugadorPorId(@PathVariable long id_jugador) {
        return jugadorService.listarPorId(id_jugador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id_jugador}")
    public ResponseEntity<Void> eliminarJugador(@PathVariable long id_jugador) {
        jugadorService.eliminar(id_jugador);
        return ResponseEntity.noContent().build();
    }
}
