package com.autocinetwo.autocinetwo.service;

import com.autocinetwo.autocinetwo.model.*;
import com.autocinetwo.autocinetwo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComprasService {

    private final ComprasRepository comprasRepository;
    private final UsuarioRepository usuarioRepository;
    private final FuncionesRepository funcionesRepository;
    private final DetalleCompraRepository detalleCompraRepository;
    private final AsientosRepository asientosRepository;

    @Transactional
    public ComprasModel createCompra(ComprasModel compra) {
        UsuarioModel usuario = usuarioRepository.findById(compra.getUsuario().getIdUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        FuncionesModel funcion = funcionesRepository.findById(compra.getFuncion().getId())
                .orElseThrow(() -> new RuntimeException("Función no encontrada"));
        
        BigDecimal total = BigDecimal.ZERO;

        for (DetalleCompraModel d : compra.getDetalles()) {
            AsientosModel asiento = asientosRepository.findById(d.getAsiento().getId())
                    .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
            
            if (asiento.getEstado() != AsientosModel.EstadoAsiento.Disponible) {
                throw new RuntimeException("Asiento " + asiento.getNumeroAsiento() + " no disponible");
            }

            total = total.add(asiento.getPrecio());
        }

        compra.setTotal(total);
        compra.setUsuario(usuario);
        compra.setFuncion(funcion);
        
        ComprasModel nuevaCompra = comprasRepository.save(compra);
        
        for (DetalleCompraModel d : compra.getDetalles()) {
            d.setCompra(nuevaCompra);
            AsientosModel asiento = d.getAsiento();
            asiento.setEstado(AsientosModel.EstadoAsiento.Reservado);
            asientosRepository.save(asiento);
            detalleCompraRepository.save(d);
        }
        
        return nuevaCompra;
    }

    public List<ComprasModel> getComprasByUsuario(Integer usuarioId) {
        return comprasRepository.findByUsuarioId(usuarioId);
    }

    public ComprasModel updateEstadoCompra(Integer id, ComprasModel.EstadoCompra nuevoEstado) {
        ComprasModel compra = comprasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        
        compra.setEstado(nuevoEstado);
        return comprasRepository.save(compra);
    }

    @Transactional
    public void cancelarCompra(Integer id) {
        ComprasModel compra = comprasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compra no encontrada"));
        
        compra.getDetalles().forEach(d -> {
            AsientosModel asiento = d.getAsiento();
            asiento.setEstado(AsientosModel.EstadoAsiento.Disponible);
            asientosRepository.save(asiento);
        });
        
        compra.setEstado(ComprasModel.EstadoCompra.CANCELADO);
        comprasRepository.save(compra);
    }
}
