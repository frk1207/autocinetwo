
package com.autocinetwo.autocinetwo.repository;

import com.autocinetwo.autocinetwo.model.FuncionesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionesRepository extends JpaRepository<FuncionesModel, Integer> {
}