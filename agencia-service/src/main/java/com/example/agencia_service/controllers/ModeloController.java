package com.example.agencia_service.controllers;



import com.example.agencia_service.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService){
        this.modeloService = modeloService;
    }

}
