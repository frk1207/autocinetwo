
package com.autocinetwo.autocinetwo.service;

import com.autocinetwo.autocinetwo.model.DetalleCompraModel;
import com.autocinetwo.autocinetwo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetalleCompraService {

    private final DetalleCompraRepository detalleCompraRepository;
    private final ComprasRepository comprasRepository;
    private final AsientosRepository asientosRepository;

    public DetalleCompraModel createDetalle(DetalleCompraModel detalle) {
        comprasRepository.findById(detalle.getCompra().getId())
            .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        
        asientosRepository.findById(detalle.getAsiento().getId())
            .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
        
        return detalleCompraRepository.save(detalle);
    }

    public List<DetalleCompraModel> getDetallesByCompra(Integer compraId) {
        return detalleCompraRepository.findByCompraId(compraId);
    }

    public void deleteDetalle(Integer id) {
        detalleCompraRepository.deleteById(id);
    }
}