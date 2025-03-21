package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.entity.VentaEntity;
import edu.cibertec.repository.VentaRepository;
import edu.cibertec.service.VentaService;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Override
    public List<VentaEntity> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public VentaEntity obtenerVenta(Integer idVenta) {
        return ventaRepository.findById(idVenta).orElse(null);
    }

    @Override
    public VentaEntity registrarVenta(VentaEntity venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public VentaEntity actualizarVenta(VentaEntity venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void eliminarVenta(Integer idVenta) {
        ventaRepository.deleteById(idVenta);
    }
}
