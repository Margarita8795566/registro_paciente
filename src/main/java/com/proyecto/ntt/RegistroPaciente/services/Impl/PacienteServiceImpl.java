package com.proyecto.ntt.RegistroPaciente.services.Impl;

import com.proyecto.ntt.RegistroPaciente.dtos.PacienteCrear;
import com.proyecto.ntt.RegistroPaciente.entities.Paciente;
import com.proyecto.ntt.RegistroPaciente.repositories.PacienteRepository;
import com.proyecto.ntt.RegistroPaciente.services.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository repository;

    public PacienteServiceImpl(PacienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> crearPaciente(PacienteCrear data) {
        try {
            Paciente paciente = new Paciente();
            paciente.setNombre(data.getNombre());
            paciente.setRut(data.getRut());
            paciente.setDireccion(data.getDireccion());
            paciente.setTelefono(data.getTelefono());
            paciente.setEmail(data.getEmail());
            Paciente pacienteRegistrado=repository.save(paciente);
            return ResponseEntity.status(HttpStatus.OK).body("Datos requistrados correctamente");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upss error");
        }

    }


    @Override
    public ResponseEntity<?> consultaTodo() {
        try {
            List<Paciente> paciente = repository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(paciente);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upss error al consultar los datos");
        }

    }

    @Override
    public ResponseEntity<?> borrar(Long id) {
        try {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upss error no se puede eliminar");
        }

    }
}
