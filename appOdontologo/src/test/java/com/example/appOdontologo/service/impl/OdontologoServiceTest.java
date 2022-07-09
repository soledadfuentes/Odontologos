package com.example.appOdontologo.service.impl;

import com.example.appOdontologo.model.OdontologoDTO;
import com.example.appOdontologo.service.IOdontologoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    IOdontologoService odontologoService;

    @Test
    public void testAgregarOdontologo(){
        OdontologoDTO prueba1 = new OdontologoDTO();
        prueba1.setNombre("José");
        prueba1.setApellido("Perez");
        prueba1.setMatricula(34987);

        odontologoService.agregarOdontologo(prueba1);
        OdontologoDTO odoJose = null;
        try {
            odoJose = odontologoService.listarOdontologo(1L);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertTrue(odoJose != null);
    }
}