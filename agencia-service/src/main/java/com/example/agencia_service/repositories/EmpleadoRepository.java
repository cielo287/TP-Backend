package com.example.agencia_service.repositories;

import com.example.agencia_service.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {


}
