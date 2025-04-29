
package com.autocinetwo.autocinetwo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocinetwo.autocinetwo.model.PagosModel;
import com.autocinetwo.autocinetwo.repository.PagosRepository;

import java.util.List;

@Service
public class PagosService {

    @Autowired
    private PagosRepository pagoRepository;

    public PagosModel savePago(PagosModel pago) {
        return pagoRepository.save(pago);
    }

    public List<PagosModel> getAllPagos() {
        return pagoRepository.findAll();
    }

    public PagosModel getPagoById(Integer id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public void deletePago(Integer id) {
        pagoRepository.deleteById(id);
    }
}
