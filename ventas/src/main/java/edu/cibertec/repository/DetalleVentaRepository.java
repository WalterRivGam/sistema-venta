package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.DetalleVentaEntity;

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaEntity, Integer> {
  
}
