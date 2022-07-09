package com.example.appOdontologo.service;

import com.example.appOdontologo.model.DomicilioDTO;

import java.util.Collection;
import java.util.Set;

public interface IDomicilioService {
    void agregarDomicilio(DomicilioDTO dom);
    DomicilioDTO listarDomicilio(Long id) throws Exception;
    void modificarDomicilio(DomicilioDTO dom);
    void eliminarDomicilio(Long id);
    Set<DomicilioDTO> listarTodos();
}
