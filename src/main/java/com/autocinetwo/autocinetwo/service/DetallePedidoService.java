
package com.autocinetwo.autocinetwo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinetwo.autocinetwo.model.DetallePedidoModel;
import com.autocinetwo.autocinetwo.repository.DetallePedidoRepository;

import java.util.List;

@Service
public class DetallePedidoService {

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoModel saveDetallePedido(DetallePedidoModel detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public List<DetallePedidoModel> getAllDetalles() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedidoModel getDetallePedidoById(Integer id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    public void deleteDetallePedido(Integer id) {
        detallePedidoRepository.deleteById(id);
    }
}
