package com.example.appOdontologo.service.impl;

import com.example.appOdontologo.model.Domicilio;
import com.example.appOdontologo.model.DomicilioDTO;
import com.example.appOdontologo.repository.IDomicilioRepository;
import com.example.appOdontologo.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {
    @Autowired
    IDomicilioRepository domicilioRepository;
    @Autowired
    ObjectMapper mapper;

    private void guardarDomicilio(DomicilioDTO dom) {
        Domicilio nuevoDomicilio = mapper.convertValue(dom, Domicilio.class);
        domicilioRepository.save(nuevoDomicilio);
    }

    @Override
    public void agregarDomicilio(DomicilioDTO dom) {
        guardarDomicilio(dom);
    }

    @Override
    public DomicilioDTO listarDomicilio(Long id) throws Exception {
        Optional<Domicilio> domi = domicilioRepository.findById(id);
        if(domi.isPresent())
            return mapper.convertValue(domi, DomicilioDTO.class);
        else
            throw new Exception("No existe el Domicilio ");
    }

    @Override
    public void modificarDomicilio(DomicilioDTO dom) {
        guardarDomicilio(dom);

    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);

    }

    @Override
    public Set<DomicilioDTO> listarTodos() {
        Set<Domicilio>  domicilios= (Set<Domicilio>) domicilioRepository.findAll();

        Set<DomicilioDTO> todoDomicilioDTO = new HashSet<>();

        for(Domicilio domicilio: domicilios)
            todoDomicilioDTO.add(mapper.convertValue(domicilio,DomicilioDTO.class));

        return todoDomicilioDTO;
    }
}
