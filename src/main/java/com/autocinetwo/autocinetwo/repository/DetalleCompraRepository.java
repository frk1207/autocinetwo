
package com.autocinetwo.autocinetwo.repository;

import com.autocinetwo.autocinetwo.model.DetalleCompraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleCompraRepository extends JpaRepository<DetalleCompraModel, Integer> {
    List<DetalleCompraModel> findByCompraId(Integer compraId);
}