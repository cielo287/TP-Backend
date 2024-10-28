package com.example.agencia_service.repositories;

import com.example.agencia_service.entities.Posiciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PosicionesRepository extends JpaRepository<Posiciones, Long> {
}
