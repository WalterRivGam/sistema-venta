package edu.cibertec.service.impl;

import java.util.List;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.entity.ClienteEntity;
import edu.cibertec.mapper.ClienteMapper;
import edu.cibertec.repository.ClienteRepository;
import edu.cibertec.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteMapper clienteMapper= Mappers.getMapper(ClienteMapper.class);

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteMapper.convertirEntityADTO(clienteRepository.findAll());

    }

    @Override
    public ClienteDTO obtenerClientes(Integer idCliente) {
        return clienteMapper.convertirEntityADTO(clienteRepository.findById(idCliente).orElse(null));
    }

    @Override
    public ClienteDTO buscarClientePorDNI(String dni) {
        return clienteMapper.convertirEntityADTO(clienteRepository.findByDni((dni)).orElse(null));
    }

    @Override
    public ClienteDTO registrarCliente(ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = clienteMapper.convertirDTOAEntity(clienteDTO);
        return clienteMapper.convertirEntityADTO(clienteRepository.save(clienteEntity));
    }

    @Override
    public ClienteDTO actualizarCliente(ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = clienteRepository.findById(clienteDTO.getId()).orElse(null);
        if (clienteEntity !=null) {
            clienteEntity.setNombres(clienteDTO.getNombres());
            clienteEntity.setApellidos(clienteDTO.getApellidos());
            clienteEntity.setEmail(clienteDTO.getEmail());
            clienteEntity.setTelefono(clienteDTO.getTelefono());
            clienteEntity.setDireccion(clienteDTO.getDireccion());
            clienteEntity.setFechaNacimiento(clienteDTO.getFechaNacimiento());

            ClienteEntity clienteActualizado = clienteRepository.save(clienteEntity);

            return clienteMapper.convertirEntityADTO(clienteActualizado);
        }
        return null;
    }

    @Override
    public ClienteDTO eliminarCliente(Integer idCliente) {
        ClienteEntity clienteEntity= clienteRepository.findById(idCliente).orElse(null);
        if (clienteEntity !=null) {
            clienteRepository.delete(clienteEntity);
            return clienteMapper.convertirEntityADTO(clienteEntity);
        }
        return null;
    }

    
    
}
