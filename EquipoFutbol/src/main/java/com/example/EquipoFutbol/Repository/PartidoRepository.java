package com.example.EquipoFutbol.Repository;

import com.example.EquipoFutbol.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    @Query(value = "SELECT SUM(goles_local) FROM partido WHERE equipo_local = :id_equipo UNION SELECT SUM(goles_visitante) FROM partido WHERE equipo_visitante = :id_equipo", nativeQuery = true)
    List<Integer> listarTotalGolesEquipo(@Param("id_equipo") Long id_equipo);
}
