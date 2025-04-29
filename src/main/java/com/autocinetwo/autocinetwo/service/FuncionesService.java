
package com.autocinetwo.autocinetwo.service;

import com.autocinetwo.autocinetwo.model.FuncionesModel;
import com.autocinetwo.autocinetwo.repository.FuncionesRepository;
import com.autocinetwo.autocinetwo.repository.PeliculasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FuncionesService {

    private final FuncionesRepository funcionesRepository;
    private final PeliculasRepository peliculasRepository;

    public List<FuncionesModel> getAllFunciones() {
        return funcionesRepository.findAll();
    }

    public Optional<FuncionesModel> getFuncionById(Integer id) {
        return funcionesRepository.findById(id);
    }

    public FuncionesModel createFuncion(FuncionesModel funcion) {
        peliculasRepository.findById(funcion.getPelicula().getId_pelicula())
            .orElseThrow(() -> new RuntimeException("Película no encontrada"));
        
        return funcionesRepository.save(funcion);
    }

    public FuncionesModel updateFuncion(Integer id, FuncionesModel funcionDetails) {
        FuncionesModel funcion = funcionesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Función no encontrada"));
        
        funcion.setFecha(funcionDetails.getFecha());
        funcion.setHora(funcionDetails.getHora());
        
        if(funcionDetails.getPelicula() != null) {
            peliculasRepository.findById(funcionDetails.getPelicula().getId_pelicula())
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));
            funcion.setPelicula(funcionDetails.getPelicula());
        }
        
        return funcionesRepository.save(funcion);
    }

    public void deleteFuncion(Integer id) {
        funcionesRepository.deleteById(id);
    }
}