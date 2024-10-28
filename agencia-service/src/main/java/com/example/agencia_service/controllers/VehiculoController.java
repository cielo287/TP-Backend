package com.example.agencia_service.controllers;


import com.example.agencia_service.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

    private final VehiculoService vehiculoService;
    @Autowired
    public VehiculoController(VehiculoService vehiculoService){
        this.vehiculoService = vehiculoService;
    }

}
