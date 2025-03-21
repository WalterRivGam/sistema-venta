package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.ProductoDTO;
import edu.cibertec.repository.ProductoRepository;
import edu.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> listarProductos() {
        return productoRepository.listarProductos();
    }

    @Override
    public ProductoDTO obtenerProducto(Integer idProducto) {
        return productoRepository.obtenerProducto(idProducto);
    }

    @Override
    public ProductoDTO registrarProducto(ProductoDTO producto) {
        return productoRepository.registrarProducto(producto);
    }

    @Override
    public void actualizarProducto(ProductoDTO producto) {
        productoRepository.actualizarProducto(producto);
    }

    @Override
    public void eliminarProducto(Integer idProducto) {
        productoRepository.eliminarProducto(idProducto);
    }
}
