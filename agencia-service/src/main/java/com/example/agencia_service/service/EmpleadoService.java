package com.example.agencia_service.service;


import com.example.agencia_service.entities.Empleado;
import com.example.agencia_service.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public List<Empleado> obtenerEmpleados() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    public boolean existeEmpleado (int legajo) {
        return empleadoRepository.existsById((long) legajo);
    }


    public Empleado obtenerEmpleadoPorLegajo(long empleadoLegajo) {
        return empleadoRepository.findById(empleadoLegajo)
                .orElseThrow(() -> new IllegalArgumentException("No existe el empleado con legajo: " + empleadoLegajo));
    }
}
