package com.autocinetwo.autocinetwo.service;

import com.autocinetwo.autocinetwo.model.DulceriaModel;
import com.autocinetwo.autocinetwo.repository.DulceriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DulceriaService {

    private final DulceriaRepository dulceriaRepository;

    public List<DulceriaModel> getAll() {
        return dulceriaRepository.findAll();
    }

    public DulceriaModel getById(Integer id) {
        return dulceriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    public DulceriaModel save(DulceriaModel producto) {
        return dulceriaRepository.save(producto);
    }

    public DulceriaModel update(Integer id, DulceriaModel actualizado) {
        DulceriaModel existente = getById(id);
        existente.setNombre(actualizado.getNombre());
        existente.setPrecio(actualizado.getPrecio());
        existente.setDescripcion(actualizado.getDescripcion());
        existente.setStock(actualizado.getStock());
        return dulceriaRepository.save(existente);
    }

    public void delete(Integer id) {
        dulceriaRepository.deleteById(id);
    }
}
