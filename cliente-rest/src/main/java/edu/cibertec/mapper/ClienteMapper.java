package edu.cibertec.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import edu.cibertec.dto.ClienteDTO;
import edu.cibertec.entity.ClienteEntity;

@Mapper
public interface ClienteMapper {
    
    public ClienteEntity convertirDTOAEntity(ClienteDTO clienteDTO);
    public ClienteDTO convertirEntityADTO(ClienteEntity clienteEntity);
    public List<ClienteEntity> convertirDTOAEntity(List<ClienteDTO> clienteDTO);
    public List<ClienteDTO> convertirEntityADTO(List<ClienteEntity> clienteEntity);

}
