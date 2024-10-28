package com.example.agencia_service.repositories;

import com.example.agencia_service.entities.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Long> {
}
