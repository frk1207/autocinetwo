package com.autocinetwo.autocinetwo.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.autocinetwo.autocinetwo.model.PeliculasModel;
import com.autocinetwo.autocinetwo.repository.PeliculasRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PeliculaService {

    private final PeliculasRepository peliculaRepository;

    public List<PeliculasModel> getAllPeliculas() {
        return peliculaRepository.findAll();
    }

    public Optional<PeliculasModel> getPeliculaById(Integer id) {
        return peliculaRepository.findById(id);
    }

    public PeliculasModel createPelicula(PeliculasModel pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public PeliculasModel updatePelicula(Integer id, PeliculasModel peliculaDetails) {
        PeliculasModel pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada con id: " + id));
        
        pelicula.setTitulo(peliculaDetails.getTitulo());
        pelicula.setDuracion(peliculaDetails.getDuracion());
        pelicula.setGenero(peliculaDetails.getGenero());
        pelicula.setClasificacion(peliculaDetails.getClasificacion());
        pelicula.setSinopsis(peliculaDetails.getSinopsis());
        pelicula.setIdioma(peliculaDetails.getIdioma());
        pelicula.setFormato(peliculaDetails.getFormato());
        
        return peliculaRepository.save(pelicula);
    }

    public void deletePelicula(Integer id) {
        PeliculasModel pelicula = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada con id: " + id));
        peliculaRepository.delete(pelicula);
    }
}
