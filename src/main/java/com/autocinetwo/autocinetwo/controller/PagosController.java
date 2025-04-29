package com.autocinetwo.autocinetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.autocinetwo.autocinetwo.model.PagosModel;
import com.autocinetwo.autocinetwo.service.PagosService;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagosController {

    @Autowired
    private PagosService pagoService;

    @PostMapping
    public PagosModel crearPago(@RequestBody PagosModel pago) {
        return pagoService.savePago(pago);
    }

    @GetMapping
    public List<PagosModel> listarPagos() {
        return pagoService.getAllPagos();
    }

    @GetMapping("/{id}")
    public PagosModel buscarPago(@PathVariable Integer id) {
        return pagoService.getPagoById(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarPago(@PathVariable Integer id) {
        pagoService.deletePago(id);
    }
}

