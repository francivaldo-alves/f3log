package com.f3pro.f3log.service;

import com.f3pro.f3log.model.Cliente;
import com.f3pro.f3log.model.Entrega;
import com.f3pro.f3log.model.StatusEntrega;
import com.f3pro.f3log.repositories.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class EntregaService {

    private EntregaRepository repository;
    private ClienteService clienteService;

    @Transactional
    public Entrega soliitar(Entrega entrega) {
        Cliente cliente= clienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return repository.save(entrega);

    }

}
