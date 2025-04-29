
package com.autocinetwo.autocinetwo.repository;

import com.autocinetwo.autocinetwo.model.ComprasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComprasRepository extends JpaRepository<ComprasModel, Integer> {
    List<ComprasModel> findByUsuarioId(Integer id);
}