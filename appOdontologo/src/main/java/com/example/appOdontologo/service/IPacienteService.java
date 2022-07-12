package com.example.appOdontologo.service;

import com.example.appOdontologo.dto.PacienteDTO;

import java.util.Set;

public interface IPacienteService {
    void agregarPaciente(PacienteDTO pcte);
    PacienteDTO listarPaciente(Long id) throws Exception;
    void modificarPaciente(PacienteDTO pcte);
    void eliminarPaciente(Long id);
    Set<PacienteDTO> listarTodos();
}
