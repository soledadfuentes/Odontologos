package com.example.appOdontologo.repository;

import com.example.appOdontologo.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository <Paciente, Long> {
}
