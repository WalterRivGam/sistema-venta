package edu.cibertec.repository;

import java.util.List;
import edu.cibertec.dto.ProductoDTO;

public interface ProductoRepository {
    public List<ProductoDTO> listarProductos();
    public ProductoDTO obtenerProducto(Integer idProducto);
    public ProductoDTO registrarProducto(ProductoDTO producto);
    public void actualizarProducto(ProductoDTO producto);
    public void eliminarProducto(Integer idProducto);
}
