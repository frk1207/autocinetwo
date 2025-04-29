package com.autocinetwo.autocinetwo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.autocinetwo.autocinetwo.model.PeliculasModel;
import com.autocinetwo.autocinetwo.service.PeliculaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
@RequiredArgsConstructor
public class PeliculaController {

    private final PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<PeliculasModel>> getAllPeliculas() {
        return new ResponseEntity<>(peliculaService.getAllPeliculas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculasModel> getPeliculaById(@PathVariable Integer id) {
        Optional<PeliculasModel> pelicula = peliculaService.getPeliculaById(id);
        return pelicula.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<PeliculasModel> createPelicula(@RequestBody PeliculasModel pelicula) {
        return new ResponseEntity<>(peliculaService.createPelicula(pelicula), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeliculasModel> updatePelicula(@PathVariable Integer id, @RequestBody PeliculasModel pelicula) {
        try {
            return new ResponseEntity<>(peliculaService.updatePelicula(id, pelicula), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable Integer id) {
        try {
            peliculaService.deletePelicula(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}