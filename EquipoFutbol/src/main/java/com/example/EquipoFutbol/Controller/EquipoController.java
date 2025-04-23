package com.example.EquipoFutbol.Controller;

import com.example.EquipoFutbol.Model.Equipo;
import com.example.EquipoFutbol.Service.EquipoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
public class EquipoController {
    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @PostMapping("/guardar")
    public ResponseEntity<Equipo> guardarEquipo(@RequestBody Equipo equipo) {
        return ResponseEntity.ok(equipoService.guardar(equipo));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Equipo>> listarEquipo() {
        return ResponseEntity.ok(equipoService.listar());
    }

    @GetMapping("/listar/{id_equipo}")
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable long id_equipo) {
        return equipoService.listarPorId(id_equipo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/eliminar/{id_equipo}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable long id_equipo) {
        equipoService.eliminar(id_equipo);
        return ResponseEntity.noContent().build();
    }
}
