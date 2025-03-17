package com.cibertec.repository;

import com.cibertec.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    // Búsqueda por código (identificador único de negocio)
    Optional<ProductoEntity> findByCodigo(String codigo);

    // Búsqueda por nombre (contiene)
    List<ProductoEntity> findByNombreContainingIgnoreCase(String nombre);

    // Búsqueda por categoría
    List<ProductoEntity> findByCategoria(String categoria);

    // Filtrar productos activos
    List<ProductoEntity> findByActivoTrue();

    // Productos con stock disponible (mayor que cero)
    List<ProductoEntity> findByStockGreaterThan(Integer stockMinimo);
}
