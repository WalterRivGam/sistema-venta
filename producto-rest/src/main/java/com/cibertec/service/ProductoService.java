package com.cibertec.service;

import com.cibertec.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {

    List<ProductoDTO> listarProductos();

    ProductoDTO buscarProductoPorId(Integer id);

    ProductoDTO guardarProducto(ProductoDTO productoDTO);

    ProductoDTO actualizarProducto(Integer id, ProductoDTO productoDTO);

    void eliminarProducto(Integer id);

    ProductoDTO buscarProductoPorCodigo(String codigo);

    List<ProductoDTO> buscarProductosPorNombre(String nombre);
}
