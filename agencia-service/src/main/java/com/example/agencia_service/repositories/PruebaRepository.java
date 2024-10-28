package com.example.agencia_service.repositories;

import com.example.agencia_service.entities.Prueba;
import com.example.agencia_service.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PruebaRepository extends JpaRepository<Prueba, Long>{



    @Query("SELECT p FROM Pruebas p WHERE :fechaHora BETWEEN p.fechaHoraInicio AND p.fechaHoraFin")
    List<Prueba> findPruebasEnCurso(@Param("fechaHora") LocalDateTime fechaHora);


}
