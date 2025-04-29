
package com.autocinetwo.autocinetwo.controller;

import com.autocinetwo.autocinetwo.model.FuncionesModel;
import com.autocinetwo.autocinetwo.service.FuncionesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/funciones")
@RequiredArgsConstructor
public class FuncionesController {

    private final FuncionesService funcionesService;

    @GetMapping
    public ResponseEntity<List<FuncionesModel>> getAllFunciones() {
        return new ResponseEntity<>(funcionesService.getAllFunciones(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionesModel> getFuncionById(@PathVariable Integer id) {
        Optional<FuncionesModel> funcion = funcionesService.getFuncionById(id);
        return funcion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<FuncionesModel> createFuncion(@RequestBody FuncionesModel funcion) {
        return new ResponseEntity<>(funcionesService.createFuncion(funcion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionesModel> updateFuncion(@PathVariable Integer id, @RequestBody FuncionesModel funcion) {
        try {
            return new ResponseEntity<>(funcionesService.updateFuncion(id, funcion), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFuncion(@PathVariable Integer id) {
        try {
            funcionesService.deleteFuncion(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}