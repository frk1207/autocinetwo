
package com.autocinetwo.autocinetwo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinetwo.autocinetwo.model.PedidoDulceriaModel;
import com.autocinetwo.autocinetwo.repository.PedidoDulceriaRepository;

@Service
public class PedidoDulceriaService {

    @Autowired
    private PedidoDulceriaRepository pedidoDulceriaRepository;

    public PedidoDulceriaModel savePedido(PedidoDulceriaModel pedidoDulceria) {
        return pedidoDulceriaRepository.save(pedidoDulceria);
    }

    public List<PedidoDulceriaModel> getAllPedidos() {
        return pedidoDulceriaRepository.findAll();
    }

    public PedidoDulceriaModel getPedidoById(Integer id) {
        return pedidoDulceriaRepository.findById(id).orElse(null);
    }

    public void deletePedido(Integer id) {
        pedidoDulceriaRepository.deleteById(id);
    }
}
