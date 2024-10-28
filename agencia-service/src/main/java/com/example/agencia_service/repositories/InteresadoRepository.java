package com.example.agencia_service.repositories;

import com.example.agencia_service.entities.Interesado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InteresadoRepository extends JpaRepository<Interesado, Long> {

    boolean existsByDocumento(String documento);

}
