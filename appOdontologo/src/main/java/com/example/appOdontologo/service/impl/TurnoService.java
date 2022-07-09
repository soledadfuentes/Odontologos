package com.example.appOdontologo.service.impl;

import com.example.appOdontologo.model.*;
import com.example.appOdontologo.repository.ITurnoRepository;
import com.example.appOdontologo.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {
    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void agregarTurno(TurnoDTO turno) {
        Turno nuevoTurno = mapper.convertValue(turno, Turno.class);
        turnoRepository.save(nuevoTurno);
    }

    @Override
    public TurnoDTO listarTurno(Long id){
        Set<Turno> turnos= (Set<Turno>) turnoRepository.findAll();

        Set<TurnoDTO> todoTurnoDTO = new HashSet<>();

        for(Turno turno: turnos)
            todoTurnoDTO.add(mapper.convertValue(turno,TurnoDTO.class));

        return (TurnoDTO) todoTurnoDTO;
    }
}