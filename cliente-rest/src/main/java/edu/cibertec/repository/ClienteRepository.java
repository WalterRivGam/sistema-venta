package edu.cibertec.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {
    Optional<ClienteEntity> findByDni(String dni);
}