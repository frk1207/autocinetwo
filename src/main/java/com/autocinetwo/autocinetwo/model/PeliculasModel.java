package com.autocinetwo.autocinetwo.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Peliculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula;
    
    @Column(nullable = false, length = 255)
    private String titulo;
    
    @Column(nullable = false)
    private Integer duracion;
    
    @Column(length = 100)
    private String genero;
    
    @Column(length = 20)
    private String clasificacion;
    
    @Column(length = 20)
    private String idioma;

    @Column(length = 20)
    private String formato;
    
    @Lob
    private String sinopsis;
}