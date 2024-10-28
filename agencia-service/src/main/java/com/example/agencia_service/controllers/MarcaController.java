package com.example.agencia_service.controllers;


import com.example.agencia_service.entities.Marca;
import com.example.agencia_service.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    private final MarcaService marcaService;
    @Autowired

    public MarcaController(MarcaService marcaService){
        this.marcaService = marcaService;
    }

    @GetMapping
    public List<Marca> obtenerMarca(){
        return marcaService.obtenerMarca();
    }

}
