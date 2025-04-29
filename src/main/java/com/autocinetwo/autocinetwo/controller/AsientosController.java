
package com.autocinetwo.autocinetwo.controller;

import com.autocinetwo.autocinetwo.model.AsientosModel;
import com.autocinetwo.autocinetwo.service.AsientosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asientos")
@RequiredArgsConstructor
public class AsientosController {

    private final AsientosService asientosService;

    @GetMapping
    public ResponseEntity<List<AsientosModel>> getAllAsientos() {
        return new ResponseEntity<>(asientosService.getAllAsientos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsientosModel> getAsientoById(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(asientosService.getAsientoById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/funcion/{funcionId}")
    public ResponseEntity<List<AsientosModel>> getAsientosByFuncion(@PathVariable Integer funcionId) {
        return new ResponseEntity<>(asientosService.getAsientosByFuncion(funcionId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AsientosModel> createAsiento(@RequestBody AsientosModel asiento) {
        try {
            return new ResponseEntity<>(asientosService.createAsiento(asiento), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<AsientosModel> updateEstado(
            @PathVariable Integer id,
            @RequestParam AsientosModel.EstadoAsiento estado) {
        try {
            return new ResponseEntity<>(asientosService.updateEstadoAsiento(id, estado), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsiento(@PathVariable Integer id) {
        try {
            asientosService.deleteAsiento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}