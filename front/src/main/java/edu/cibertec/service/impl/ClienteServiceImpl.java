package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.repository.ClienteRepository;
import edu.cibertec.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepository.listarClientes();
    }

    @Override
    public ClienteDTO obtenerCliente(Integer idCliente) {
        return clienteRepository.obtenerCliente(idCliente);
    }

    @Override
    public ClienteDTO registrarCliente(ClienteDTO cliente) {
        return clienteRepository.registrarCliente(cliente);
    }

    @Override
    public void actualizarCliente(ClienteDTO cliente) {
        clienteRepository.actualizarCliente(cliente);
    }

    @Override
    public void eliminarCliente(Integer idCliente) {
        clienteRepository.eliminarCliente(idCliente);
    }
}
