package com.example.appOdontologo.service.impl;

import com.example.appOdontologo.dto.OdontologoDTO;
import com.example.appOdontologo.model.*;
import com.example.appOdontologo.repository.IOdontologoRepository;
import com.example.appOdontologo.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    public static final Logger logger = Logger.getLogger(OdontologoService.class);
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarOdontologo(OdontologoDTO odo) {
        Odontologo nuevoOdontologo = mapper.convertValue(odo, Odontologo.class);
        odontologoRepository.save(nuevoOdontologo);

    }

    @Override
    public void agregarOdontologo(OdontologoDTO odo) {
        guardarOdontologo(odo);
        //Logger
        logger.info("Odontologo guardado");
    }

    @Override
    public OdontologoDTO listarOdontologo(Long id) throws Exception {
        Optional<Odontologo> odo = odontologoRepository.findById(id);
        if(odo.isPresent())
            return mapper.convertValue(odo, OdontologoDTO.class);
        else
            throw new Exception("No existe el Odontologo");
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odo) {
        guardarOdontologo(odo);
        //Logger
        logger.info("Odontologo modificado");
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        //Logger
        logger.info("Odontologo eliminado");
    }

    @Override
    public Set<OdontologoDTO> listarTodos() {
        List<Odontologo> odontologos= odontologoRepository.findAll();

        Set<OdontologoDTO> todoOdontologoDTO = new HashSet<>();

        for(Odontologo odontologo: odontologos)
            todoOdontologoDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));

        return todoOdontologoDTO;
    }
}