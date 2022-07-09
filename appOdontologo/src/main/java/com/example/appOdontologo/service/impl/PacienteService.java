package com.example.appOdontologo.service.impl;

import com.example.appOdontologo.model.*;
import com.example.appOdontologo.repository.IPacienteRepository;
import com.example.appOdontologo.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {
    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    private void guardarPaciente(PacienteDTO pcte) {
        Paciente nuevoPaciente = mapper.convertValue(pcte, Paciente.class);
        pacienteRepository.save(nuevoPaciente);
    }

    @Override
    public void agregarPaciente(PacienteDTO pcte) {
        guardarPaciente(pcte);
    }

    @Override
    public PacienteDTO listarPaciente(Long id) throws Exception {
        Optional<Paciente> pcte = pacienteRepository.findById(id);
        if(pcte.isPresent())
            return mapper.convertValue(pcte, PacienteDTO.class);
        else
            throw new Exception("No existe el Paciente ");
    }

    @Override
    public void modificarPaciente(PacienteDTO pcte) {
        guardarPaciente(pcte);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDTO> listarTodos() {
        Set<Paciente> pacientes= (Set<Paciente>) pacienteRepository.findAll();

        Set<PacienteDTO> todoPacienteDTO = new HashSet<>();

        for(Paciente paciente: pacientes)
            todoPacienteDTO.add(mapper.convertValue(paciente,PacienteDTO.class));

        return todoPacienteDTO;
    }
}
