package com.example.agencia_service.service;




import com.example.agencia_service.entities.Marca;
import com.example.agencia_service.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    private final MarcaRepository marcaRepository;
    @Autowired
    public MarcaService(MarcaRepository marcaRepository){
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> obtenerMarca(){
        return (List<Marca>) marcaRepository.findAll();
    }
}
