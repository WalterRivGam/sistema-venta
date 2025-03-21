package edu.cibertec.service;

import java.util.List;
import edu.cibertec.dto.DetalleVentaDTO;

public interface DetalleVentaService {
    List<DetalleVentaDTO> listarDetallesVenta();
    List<DetalleVentaDTO> listarDetallesVenta(Integer idVenta);
    DetalleVentaDTO obtenerDetalleVenta(Integer idDetalleVenta);
    DetalleVentaDTO registrarDetalleVenta(DetalleVentaDTO detalleVenta);
    void actualizarDetalleVenta(DetalleVentaDTO detalleVenta);
    void eliminarDetalleVenta(Integer idDetalleVenta);
}
