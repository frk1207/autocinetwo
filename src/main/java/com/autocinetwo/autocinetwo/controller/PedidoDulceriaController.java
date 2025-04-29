package com.autocinetwo.autocinetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.autocinetwo.autocinetwo.model.PedidoDulceriaModel;
import com.autocinetwo.autocinetwo.service.PedidoDulceriaService;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoDulceriaController {

    @Autowired
    private PedidoDulceriaService pedidoDulceriaService;

    @PostMapping
    public PedidoDulceriaModel createPedido(@RequestBody PedidoDulceriaModel pedidoDulceria) {
        return pedidoDulceriaService.savePedido(pedidoDulceria);
    }

    @GetMapping
    public List<PedidoDulceriaModel> getAllPedidos() {
        return pedidoDulceriaService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public PedidoDulceriaModel getPedidoById(@PathVariable Integer id) {
        return pedidoDulceriaService.getPedidoById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePedido(@PathVariable Integer id) {
        pedidoDulceriaService.deletePedido(id);
    }
}
