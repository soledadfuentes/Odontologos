package com.example.appOdontologo.service.impl;

import com.example.appOdontologo.dto.TurnoDTO;
import com.example.appOdontologo.model.*;
import com.example.appOdontologo.repository.ITurnoRepository;
import com.example.appOdontologo.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {
    public static final Logger logger = Logger.getLogger(OdontologoService.class);
    @Autowired
    ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void agregarTurno(TurnoDTO turno) {
        Turno nuevoTurno = mapper.convertValue(turno, Turno.class);
        turnoRepository.save(nuevoTurno);
        //Logger
        logger.info("Turno guardado");
    }

    @Override
    public Set<TurnoDTO> listarTodos(){
        List<Turno> turnos= turnoRepository.findAll();

        Set<TurnoDTO> todoTurnoDTO = new HashSet<>();

        for(Turno turno: turnos)
            todoTurnoDTO.add(mapper.convertValue(turno,TurnoDTO.class));

        return todoTurnoDTO;
    }
}