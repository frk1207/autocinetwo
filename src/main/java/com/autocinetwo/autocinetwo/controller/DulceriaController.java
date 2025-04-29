package com.autocinetwo.autocinetwo.controller;

import com.autocinetwo.autocinetwo.model.DulceriaModel;
import com.autocinetwo.autocinetwo.service.DulceriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dulceria")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class DulceriaController {

    private final DulceriaService dulceriaService;

    @GetMapping
    public List<DulceriaModel> getAll() {
        return dulceriaService.getAll();
    }

    @GetMapping("/{id}")
    public DulceriaModel getById(@PathVariable Integer id) {
        return dulceriaService.getById(id);
    }

    @PostMapping
    public DulceriaModel create(@RequestBody DulceriaModel producto) {
        return dulceriaService.save(producto);
    }

    @PutMapping("/{id}")
    public DulceriaModel update(@PathVariable Integer id, @RequestBody DulceriaModel producto) {
        return dulceriaService.update(id, producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        dulceriaService.delete(id);
    }
}
