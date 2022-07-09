package com.example.appOdontologo.service;

import com.example.appOdontologo.model.TurnoDTO;

import java.util.Set;

public interface ITurnoService {
    void agregarTurno(TurnoDTO turno);
    TurnoDTO listarTurno(Long id) throws Exception;
}
