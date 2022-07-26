package com.f3pro.f3log.controller;

import com.f3pro.f3log.model.Cliente;
import com.f3pro.f3log.model.Entrega;
import com.f3pro.f3log.repositories.EntregaRepository;
import com.f3pro.f3log.service.EntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/entregas")
public class EntregaController {

    private EntregaService service;
    private EntregaRepository repository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return service.soliitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entrega> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
