
package com.autocinetwo.autocinetwo.service;

import com.autocinetwo.autocinetwo.model.AsientosModel;
import com.autocinetwo.autocinetwo.repository.AsientosRepository;
import com.autocinetwo.autocinetwo.repository.FuncionesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsientosService {

    private final AsientosRepository asientosRepository;
    private final FuncionesRepository funcionesRepository;

    public List<AsientosModel> getAllAsientos() {
        return asientosRepository.findAll();
    }

    public AsientosModel getAsientoById(Integer id) {
        return asientosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
    }

    public List<AsientosModel> getAsientosByFuncion(Integer funcionId) {
        return asientosRepository.findByFuncionId(funcionId);
    }

    public AsientosModel createAsiento(AsientosModel asiento) {
        funcionesRepository.findById(asiento.getFuncion().getId())
                .orElseThrow(() -> new RuntimeException("Función no encontrada"));
    
        if(asientosRepository.existsByFuncionAndNumeroAsiento(asiento.getFuncion(), asiento.getNumeroAsiento())) {
            throw new RuntimeException("El asiento ya existe para esta función");
        }
        
        return asientosRepository.save(asiento);
    }

    public AsientosModel updateEstadoAsiento(Integer id, AsientosModel.EstadoAsiento nuevoEstado) {
        AsientosModel asiento = asientosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        
        asiento.setEstado(nuevoEstado);
        return asientosRepository.save(asiento);
    }

    public void deleteAsiento(Integer id) {
        asientosRepository.deleteById(id);
    }
}