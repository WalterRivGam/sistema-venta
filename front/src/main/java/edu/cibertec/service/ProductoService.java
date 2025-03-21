package edu.cibertec.service;

import java.util.List;
import edu.cibertec.dto.ProductoDTO;

public interface ProductoService {
    List<ProductoDTO> listarProductos();
    ProductoDTO obtenerProducto(Integer idProducto);
    ProductoDTO registrarProducto(ProductoDTO producto);
    void actualizarProducto(ProductoDTO producto);
    void eliminarProducto(Integer idProducto);
}
