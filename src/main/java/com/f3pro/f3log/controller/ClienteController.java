package com.f3pro.f3log.controller;

import com.f3pro.f3log.repositories.ClienteRepository;
import com.f3pro.f3log.model.Cliente;
import com.f3pro.f3log.service.ClienteService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "clientes")

public class ClienteController {


    private ClienteRepository repository;
    
    private ClienteService service;

    @GetMapping()
    public List<Cliente> listar() {
        return repository.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adcioonar(@Valid @RequestBody Cliente cliente) {
        return service.salvar(cliente);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id, @RequestBody Cliente cliente) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        cliente = repository.save(cliente);
        return ResponseEntity.ok(cliente);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        service.excluir(id);
        return ResponseEntity.noContent().build();

    }
}
