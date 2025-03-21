package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.dto.VentaDTO;
import edu.cibertec.repository.VentaRepository;
import edu.cibertec.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<VentaDTO> listarVentas() {
      return ventaRepository.listarventas();
    }

    @Override
    public VentaDTO obtenerVenta(Integer idVenta) {
      return ventaRepository.obtenerVenta(idVenta);
    }

    @Override
    public VentaDTO registrarVenta(VentaDTO venta) {
      return ventaRepository.registrarVenta(venta);
    }

    @Override
    public void actualizarVenta(VentaDTO venta) {
        ventaRepository.actualizarVenta(venta);
    }

    @Override
    public void eliminarVenta(Integer idVenta) {
        ventaRepository.eliminarVenta(idVenta);
    }
}
