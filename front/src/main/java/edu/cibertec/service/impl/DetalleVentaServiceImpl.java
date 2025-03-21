package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.DetalleVentaDTO;
import edu.cibertec.repository.DetalleVentaRepository;
import edu.cibertec.service.DetalleVentaService;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    @Override
    public List<DetalleVentaDTO> listarDetallesVenta() {
        return detalleVentaRepository.listarDetallesVenta();
    }

    @Override
    public DetalleVentaDTO obtenerDetalleVenta(Integer idDetalleVenta) {
        return detalleVentaRepository.obtenerDetalleVenta(idDetalleVenta);
    }

    @Override
    public DetalleVentaDTO registrarDetalleVenta(DetalleVentaDTO detalleVenta) {
        return detalleVentaRepository.registrarDetalleVenta(detalleVenta);
    }

    @Override
    public void actualizarDetalleVenta(DetalleVentaDTO detalleVenta) {
        detalleVentaRepository.actualizarDetalleVenta(detalleVenta);
    }

    @Override
    public void eliminarDetalleVenta(Integer idDetalleVenta) {
        detalleVentaRepository.eliminarDetalleVenta(idDetalleVenta);
    }

    @Override
    public List<DetalleVentaDTO> listarDetallesVenta(Integer idVenta) {
        return detalleVentaRepository.listarDetallesVenta(idVenta);
    }
}
