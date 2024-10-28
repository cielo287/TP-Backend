package com.example.agencia_service.repositories;

import com.example.agencia_service.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca,Long> {
}
