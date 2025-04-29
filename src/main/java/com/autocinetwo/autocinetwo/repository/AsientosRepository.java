
package com.autocinetwo.autocinetwo.repository;

import com.autocinetwo.autocinetwo.model.AsientosModel;
import com.autocinetwo.autocinetwo.model.FuncionesModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsientosRepository extends JpaRepository<AsientosModel, Integer> {
    List<AsientosModel> findByFuncionId(Integer funcionId);
    boolean existsByFuncionAndNumeroAsiento(FuncionesModel funcion, String numeroAsiento);
}