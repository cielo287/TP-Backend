package com.example.agencia_service.repositories;

import com.example.agencia_service.entities.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo,Long> {
}
