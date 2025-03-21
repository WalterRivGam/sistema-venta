package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.DetalleVentaEntity;
import edu.cibertec.repository.DetalleVentaRepository;
import edu.cibertec.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVentaEntity> listarDetallesVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVentaEntity obtenerDetalleVenta(Integer idDetalleVenta) {
        return detalleVentaRepository.findById(idDetalleVenta).orElse(null);
    }

    @Override
    public DetalleVentaEntity registrarDetalleVenta(DetalleVentaEntity detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVentaEntity actualizarDetalleVenta(DetalleVentaEntity detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void eliminarDetalleVenta(Integer idDetalleVenta) {
        detalleVentaRepository.deleteById(idDetalleVenta);
    }
}
