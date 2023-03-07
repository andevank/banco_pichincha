package com.co.banco.pichincha.service;

import com.co.banco.pichincha.dto.ClienteDTO;
import com.co.banco.pichincha.exception.ResourceNotFoundException;
import com.co.banco.pichincha.mapper.ClienteMapper;
import com.co.banco.pichincha.model.Cliente;
import com.co.banco.pichincha.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ClienteDTO> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream().map(ClienteMapper::maptoClienteDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteDTO getClienteById(Long id) {
        Optional<Cliente> result = clienteRepository.findById(id);

        if(result.isEmpty()){
            throw new ResourceNotFoundException("Cliente no encontrado con el id = "+id);
        }
        Cliente cliente = result.get();
        return ClienteMapper.maptoClienteDTO(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return clienteRepository.count();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ClienteDTO crearCliente(ClienteDTO clienteDTO) {

        if(clienteDTO==null){
            throw new ResourceNotFoundException("El Cliente es nulo");
        }
        Cliente cliente= ClienteMapper.maptoCliente(clienteDTO);
        Cliente saveCliente=clienteRepository.save(cliente);

        ClienteDTO saveClienteDTO=ClienteMapper.maptoClienteDTO(saveCliente);

        return saveClienteDTO;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO){

        Cliente currentCliente=clienteRepository.findById(clienteDTO.getClienteid()).get();

        if(currentCliente==null){
            throw new ResourceNotFoundException("La Cliente es nula");
        }
        if(currentCliente.getClienteId()==null){
            throw new ResourceNotFoundException("La Cliente no esta registrada");
        }

        currentCliente.setClienteid(clienteDTO.getClienteid());
        currentCliente.setContrasena(clienteDTO.getContrasena());
        currentCliente.setEstado(clienteDTO.getEstado());
        currentCliente.setPersona(clienteDTO.getPersona());

        Cliente updateCliente=clienteRepository.save(currentCliente);

        return ClienteMapper.maptoClienteDTO(updateCliente);
    }
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteById(Long id) throws Exception {
        clienteRepository.deleteById(id);
    }
}
