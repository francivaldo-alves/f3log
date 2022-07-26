package com.f3pro.f3log.service;

import javax.transaction.Transactional;

import com.f3pro.f3log.domain.NegocioException;
import org.springframework.stereotype.Service;

import com.f3pro.f3log.repositories.ClienteRepository;
import com.f3pro.f3log.model.Cliente;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

	private ClienteRepository repository;

	public Cliente buscar (Long clienteId){
		return repository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("CLiente não encontrado"));

	}
	

	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso =repository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		if (emailEmUso){
			throw  new NegocioException("já existe um cliente com esse e-mail");

		}
		return repository.save(cliente);
	}

	@Transactional
	public void excluir(Long id) {
		
		repository.deleteById(id);
	}
}
