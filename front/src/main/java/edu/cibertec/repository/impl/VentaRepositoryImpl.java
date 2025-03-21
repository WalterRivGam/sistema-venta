package edu.cibertec.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import edu.cibertec.dto.VentaDTO;
import edu.cibertec.repository.VentaRepository;

@Repository
public class VentaRepositoryImpl implements VentaRepository {

  private RestTemplate restTemplate;

  @Value("${url.api}")
  private String urlApi;
    
  public VentaRepositoryImpl() {
        this.restTemplate = new RestTemplate();
    }

  @Override
  public List<VentaDTO> listarventas() {
    return restTemplate.getForObject(urlApi + "/ventas", List.class);
  }

  @Override
  public VentaDTO obtenerVenta(Integer idVenta) {
    return restTemplate.getForObject(urlApi + "/ventas/" + idVenta, VentaDTO.class);
  }

  @Override
  public VentaDTO registrarVenta(VentaDTO venta) {
    return restTemplate.postForObject(urlApi + "/ventas", venta, VentaDTO.class);
  }

  @Override
  public void actualizarVenta(VentaDTO venta) {
    restTemplate.put(urlApi + "/ventas/" + venta.getId(), venta);
  }

  @Override
  public void eliminarVenta(Integer idVenta) {
    restTemplate.delete(urlApi + "/ventas/" + idVenta);
  }
  
}
