package com.cibertec.service.impl;

import com.cibertec.dto.ProductoDTO;
import com.cibertec.entity.ProductoEntity;
import com.cibertec.mapper.ProductoMapper;
import com.cibertec.repository.ProductoRepository;
import com.cibertec.service.ProductoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    /* NO uses Mappers.getMapper - Usa inyección de dependencias
    private ProductoMapper productoMapper = Mappers.getMapper(ProductoMapper.class);
    */

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> listarProductos() {
        List<ProductoEntity> productos = productoRepository.findAll();
        return productoMapper.convertirEntityADTO(productos);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO buscarProductoPorId(Integer id) {
        ProductoEntity producto = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return productoMapper.convertirEntityADTO(producto);
    }

    @Override
    @Transactional
    public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
        ProductoEntity producto = productoMapper.convertirDTOAEntity(productoDTO);
        ProductoEntity guardado = productoRepository.save(producto);
        return productoMapper.convertirEntityADTO(guardado);
    }

    @Override
    @Transactional
    public ProductoDTO actualizarProducto(Integer id, ProductoDTO productoDTO) {
        // Verificar si existe
        productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Asegurar que el ID sea el correcto
        productoDTO.setId(id);

        ProductoEntity producto = productoMapper.convertirDTOAEntity(productoDTO);
        ProductoEntity actualizado = productoRepository.save(producto);
        return productoMapper.convertirEntityADTO(actualizado);
    }

    @Override
    @Transactional
    public void eliminarProducto(Integer id) {
        // Verificar si existe
        productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        productoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoDTO buscarProductoPorCodigo(String codigo) {
        ProductoEntity producto = productoRepository.findByCodigo(codigo)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return productoMapper.convertirEntityADTO(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoDTO> buscarProductosPorNombre(String nombre) {
        List<ProductoEntity> productos = productoRepository.findByNombreContainingIgnoreCase(nombre);
        return productoMapper.convertirEntityADTO(productos);
    }
}