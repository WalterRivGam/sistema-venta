package com.cibertec.service.impl;

import com.cibertec.entity.ProductoEntity;
import com.cibertec.repository.ProductoRepository;
import com.cibertec.service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> listarProductos() {
        log.debug("Listando todos los productos");
        return productoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoEntity buscarProductoPorId(Integer id) {
        log.debug("Buscando producto con id {}", id);
        if (id == null) {
            throw new IllegalArgumentException("El id del producto no puede ser nulo");
        }
        return productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El producto no existe"));
    }

    @Override
    @Transactional
    public ProductoEntity guardarProducto(ProductoEntity productoEntity) {
        log.debug("Guardando producto con id {}", productoEntity.getId());
        if (productoEntity == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        return productoRepository.save(productoEntity);
    }

    @Override
    @Transactional
    public ProductoEntity eliminarProducto(Integer id) {
        log.debug("Eliminando producto con id {}", id);
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        productoRepository.deleteById(id);
        return producto;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoEntity buscarProductoPorCodigo(String codigo) throws IllegalArgumentException {
        log.debug("Buscando producto con código {}", codigo);
        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException("El código del producto no puede ser nulo o vacío");
        }
        return productoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Producto con código " + codigo + " no encontrado"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> buscarProductosPorNombre(String nombre) {
        log.debug("Buscando productos que contengan '{}' en su nombre", nombre);
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre para la búsqueda no puede ser nulo o vacío");
        }
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> buscarProductosPorCategoria(String categoria) {
        log.debug("Buscando productos de la categoría {}", categoria);
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("La categoría no puede ser nula o vacía");
        }
        return productoRepository.findByCategoria(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> listarProductosActivos() {
        log.debug("Listando todos los productos activos");
        return productoRepository.findByActivoTrue();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoEntity> listarProductosConStock(Integer stockMinimo) {
        log.debug("Listando productos con stock mayor a {}", stockMinimo);
        if (stockMinimo == null) {
            stockMinimo = 0; // Valor por defecto si es nulo
        }
        return productoRepository.findByStockGreaterThan(stockMinimo);
    }
}