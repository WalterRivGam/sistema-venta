package edu.cibertec.service;

import java.util.List;

import edu.cibertec.dto.VentaDTO;

public interface VentaService {
  public List<VentaDTO> listarVentas();
  public VentaDTO obtenerVenta(Integer idVenta);
  public VentaDTO registrarVenta(VentaDTO venta);
  public void actualizarVenta(VentaDTO venta);
  public void eliminarVenta(Integer idVenta);
}
