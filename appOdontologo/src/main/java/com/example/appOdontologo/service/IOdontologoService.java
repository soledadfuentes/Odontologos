package com.example.appOdontologo.service;

 import com.example.appOdontologo.model.OdontologoDTO;

 import java.util.Set;

public interface IOdontologoService {
    void agregarOdontologo(OdontologoDTO odo);
    OdontologoDTO listarOdontologo(Long id) throws Exception;
    void modificarOdontologo(OdontologoDTO odo);
    void eliminarOdontologo(Long id);
    Set<OdontologoDTO> listarTodos();
}
