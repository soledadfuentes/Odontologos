package com.example.appOdontologo.controller;

import com.example.appOdontologo.dto.PacienteDTO;
import com.example.appOdontologo.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> agregarPaciente(@RequestBody PacienteDTO pcte) {
        pacienteService.agregarPaciente(pcte);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PacienteDTO listarPaciente(@PathVariable Long id) throws Exception {
        return pacienteService.listarPaciente(id);
    }

    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pcte) {
        pacienteService.modificarPaciente(pcte);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/listar")
    public ResponseEntity<Collection<PacienteDTO>> listarPacientes() {

        return ResponseEntity.ok(pacienteService.listarTodos());
    }
}
