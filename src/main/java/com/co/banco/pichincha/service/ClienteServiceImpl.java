package com.co.banco.pichincha.service;

import com.co.banco.pichincha.model.Cliente;
import com.co.banco.pichincha.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(final Cliente cliente) {
        return this.clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(final Cliente cliente) {
        return this.clienteRepository.saveAndFlush(cliente);
    }

    @Override
    public void eliminarCliente(final Long id) {
        this.clienteRepository.deleteById(id);
    }

    @Override
    public Page<Cliente> getClientes(final Integer page, final Integer size, final Boolean enablePagination) {
        return this.clienteRepository.findAll(enablePagination? PageRequest.of(page,size): Pageable.unpaged());
    }

    @Override
    public Optional<Cliente> getClienteId(final Long id) {
        return Optional.of(this.clienteRepository.findById(id).get());
    }

    @Override
    public boolean exitsById(final Long id){
        return this.clienteRepository.existsById(id);
    }
}
