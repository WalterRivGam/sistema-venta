package edu.cibertec.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoRepository;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

    private RestTemplate restTemplate;

    @Value("${url.api}")
    private String urlApi;

    public ProductoRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        return restTemplate.getForObject(urlApi + "/productos", List.class);
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        return restTemplate.getForObject(urlApi + "/productos/" + idProducto, ProductoDTO.class);
    }

    @Override
    public ProductoDTO registrarProducto(ProductoDTO producto) {
        return restTemplate.postForObject(urlApi + "/productos", producto, ProductoDTO.class);
    }

    @Override
    public void actualizarProducto(ProductoDTO producto) {
        restTemplate.put(urlApi + "/productos/" + producto.getId(), producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        restTemplate.delete(urlApi + "/productos/" + idProducto);
    }
}
