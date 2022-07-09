package com.example.appOdontologo.service.impl;

import com.example.appOdontologo.model.*;
import com.example.appOdontologo.repository.IOdontologoRepository;
import com.example.appOdontologo.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
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
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> listarTodos() {
        Set<Odontologo>  odontologos= (Set<Odontologo>) odontologoRepository.findAll();

        Set<OdontologoDTO> todoOdontologoDTO = new HashSet<>();

        for(Odontologo odontologo: odontologos)
            todoOdontologoDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));

        return todoOdontologoDTO;
    }
}