package com.autocinetwo.autocinetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.autocinetwo.autocinetwo.model.DetallePedidoModel;
import com.autocinetwo.autocinetwo.service.DetallePedidoService;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @PostMapping
    public DetallePedidoModel createDetallePedido(@RequestBody DetallePedidoModel detallePedido) {
        return detallePedidoService.saveDetallePedido(detallePedido);
    }

    @GetMapping
    public List<DetallePedidoModel> getAllDetalles() {
        return detallePedidoService.getAllDetalles();
    }

    @GetMapping("/{id}")
    public DetallePedidoModel getDetallePedidoById(@PathVariable Integer id) {
        return detallePedidoService.getDetallePedidoById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDetallePedido(@PathVariable Integer id) {
        detallePedidoService.deleteDetallePedido(id);
    }
}

