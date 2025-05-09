package com.fiap.brinquedos.brinquedos_api.controller;

import com.fiap.brinquedos.brinquedos_api.entity.Brinquedo;
import com.fiap.brinquedos.brinquedos_api.repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoRepository repository;

    @GetMapping
    public List<Brinquedo> getAllBrinquedos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Brinquedo> getBrinquedoById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Brinquedo createBrinquedo(@RequestBody Brinquedo brinquedo) {
        return repository.save(brinquedo);
    }
}
