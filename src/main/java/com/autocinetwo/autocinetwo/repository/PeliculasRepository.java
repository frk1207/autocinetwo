package com.autocinetwo.autocinetwo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autocinetwo.autocinetwo.model.PeliculasModel;

@Repository
public interface PeliculasRepository extends JpaRepository<PeliculasModel, Integer> {
}