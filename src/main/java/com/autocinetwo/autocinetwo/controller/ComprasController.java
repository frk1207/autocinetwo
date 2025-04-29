
package com.autocinetwo.autocinetwo.controller;

import com.autocinetwo.autocinetwo.model.ComprasModel;
import com.autocinetwo.autocinetwo.service.ComprasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
@RequiredArgsConstructor
public class ComprasController {

    private final ComprasService comprasService;

    @PostMapping
    public ResponseEntity<ComprasModel> createCompra(@RequestBody ComprasModel compra) {
        try {
            return new ResponseEntity<>(comprasService.createCompra(compra), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ComprasModel>> getComprasByUsuario(@PathVariable Integer usuarioId) {
        return new ResponseEntity<>(comprasService.getComprasByUsuario(usuarioId), HttpStatus.OK);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<ComprasModel> updateEstado(
            @PathVariable Integer id,
            @RequestParam ComprasModel.EstadoCompra estado) {
        try {
            return new ResponseEntity<>(comprasService.updateEstadoCompra(id, estado), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarCompra(@PathVariable Integer id) {
        try {
            comprasService.cancelarCompra(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}