package com.autocinetwo.autocinetwo.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.autocinetwo.autocinetwo.model.UsuarioModel;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
    Optional<UsuarioModel> findByCorreo(String correo);
}
