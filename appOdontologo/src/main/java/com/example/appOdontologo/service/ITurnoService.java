package com.example.appOdontologo.service;

import com.example.appOdontologo.dto.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void agregarTurno(TurnoDTO turno);
    Set<TurnoDTO> listarTodos();
}

