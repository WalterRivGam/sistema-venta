package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.VentaEntity;

public interface VentaRepository extends JpaRepository<VentaEntity, Integer> {
  
}
