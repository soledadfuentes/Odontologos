package com.example.appOdontologo.controller;


import com.example.appOdontologo.dto.OdontologoDTO;
import com.example.appOdontologo.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    @Autowired
    IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> agregarOdontologo(@RequestBody OdontologoDTO odo) {
        odontologoService.agregarOdontologo(odo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public OdontologoDTO listarOdontologo(@PathVariable Long id) throws Exception {
        return odontologoService.listarOdontologo(id);
    }

    @PutMapping()
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odo) {
        odontologoService.modificarOdontologo(odo);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<Collection<OdontologoDTO>> listarOdontologos() {

        return ResponseEntity.ok(odontologoService.listarTodos());
    }
}
