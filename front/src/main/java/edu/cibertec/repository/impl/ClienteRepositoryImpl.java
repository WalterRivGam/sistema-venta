package edu.cibertec.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.repository.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private RestTemplate restTemplate;

    @Value("${url.api}")
    private String urlApi;

    public ClienteRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return restTemplate.getForObject(urlApi + "/clientes", List.class);
    }

    @Override
    public ClienteDTO obtenerCliente(Integer idCliente) {
        return restTemplate.getForObject(urlApi + "/clientes/" + idCliente, ClienteDTO.class);
    }

    @Override
    public ClienteDTO registrarCliente(ClienteDTO cliente) {
        return restTemplate.postForObject(urlApi + "/clientes", cliente, ClienteDTO.class);
    }

    @Override
    public void actualizarCliente(ClienteDTO cliente) {
        restTemplate.put(urlApi + "/clientes/" + cliente.getId(), cliente);
    }

    @Override
    public void eliminarCliente(Integer idCliente) {
        restTemplate.delete(urlApi + "/clientes/" + idCliente);
    }
}
