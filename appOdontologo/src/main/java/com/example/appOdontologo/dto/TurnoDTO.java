package com.example.appOdontologo.dto;

import com.example.appOdontologo.model.Odontologo;
import com.example.appOdontologo.model.Paciente;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoDTO {
    private Long id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDate fecha;
    private LocalTime hora;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
