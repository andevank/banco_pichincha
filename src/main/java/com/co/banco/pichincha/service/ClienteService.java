package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.ClienteDTO;

import java.util.List;

public interface ClienteService {

    List<ClienteDTO> getAllClientes();

    ClienteDTO getClienteById(Long id);

    ClienteDTO crearCliente(ClienteDTO entity);

    ClienteDTO actualizarCliente(ClienteDTO entity) throws Exception;

    void deleteById(Long id) throws Exception;

    Long count();
}
