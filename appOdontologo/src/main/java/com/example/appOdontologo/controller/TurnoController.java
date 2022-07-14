package com.example.appOdontologo.controller;

import com.example.appOdontologo.dto.TurnoDTO;
import com.example.appOdontologo.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    ITurnoService turnoService;


    @PostMapping
    public ResponseEntity<?> agregarTurno(@RequestBody TurnoDTO turno) {
        turnoService.agregarTurno(turno);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<Collection<TurnoDTO>> listarTurnos() {

        return ResponseEntity.ok(turnoService.listarTodos());
    }
}


