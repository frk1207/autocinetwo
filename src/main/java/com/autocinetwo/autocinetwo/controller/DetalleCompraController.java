
package com.autocinetwo.autocinetwo.controller;

import com.autocinetwo.autocinetwo.model.DetalleCompraModel;
import com.autocinetwo.autocinetwo.service.DetalleCompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-compra")
@RequiredArgsConstructor
public class DetalleCompraController {

    private final DetalleCompraService detalleCompraService;

    @PostMapping
    public ResponseEntity<DetalleCompraModel> createDetalle(@RequestBody DetalleCompraModel detalle) {
        try {
            return new ResponseEntity<>(detalleCompraService.createDetalle(detalle), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/compra/{compraId}")
    public ResponseEntity<List<DetalleCompraModel>> getByCompra(@PathVariable Integer compraId) {
        return new ResponseEntity<>(detalleCompraService.getDetallesByCompra(compraId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Integer id) {
        try {
            detalleCompraService.deleteDetalle(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
