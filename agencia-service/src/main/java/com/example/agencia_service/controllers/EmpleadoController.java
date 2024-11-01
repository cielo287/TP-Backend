package com.example.agencia_service.controllers;


import com.example.agencia_service.entities.Empleado;
import com.example.agencia_service.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleados")
 class EmpleadoController {
    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> obtenerEmpleados(){
        return empleadoService.obtenerEmpleados();
    }

}
