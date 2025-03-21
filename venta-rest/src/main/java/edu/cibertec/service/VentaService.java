package edu.cibertec.service;

import java.util.List;
import edu.cibertec.entity.VentaEntity;

public interface VentaService {
    List<VentaEntity> listarVentas();
    VentaEntity obtenerVenta(Integer idVenta);
    VentaEntity registrarVenta(VentaEntity venta);
    VentaEntity actualizarVenta(VentaEntity venta);
    void eliminarVenta(Integer idVenta);
}
