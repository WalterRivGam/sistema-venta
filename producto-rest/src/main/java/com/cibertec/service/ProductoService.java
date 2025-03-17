package com.cibertec.service;

import com.cibertec.entity.ProductoEntity;

import java.util.List;

public interface ProductoService {
    // Métodos CRUD básicos
    List<ProductoEntity> listarProductos();

    ProductoEntity buscarProductoPorId(Integer id) throws IllegalArgumentException;

    ProductoEntity guardarProducto(ProductoEntity productoEntity) throws IllegalArgumentException;

    ProductoEntity eliminarProducto(Integer id) throws IllegalArgumentException;

    // Métodos adicionales basados en el repositorio
    ProductoEntity buscarProductoPorCodigo(String codigo) throws IllegalArgumentException;

    List<ProductoEntity> buscarProductosPorNombre(String nombre);

    List<ProductoEntity> buscarProductosPorCategoria(String categoria);

    List<ProductoEntity> listarProductosActivos();

    List<ProductoEntity> listarProductosConStock(Integer stockMinimo);
}
