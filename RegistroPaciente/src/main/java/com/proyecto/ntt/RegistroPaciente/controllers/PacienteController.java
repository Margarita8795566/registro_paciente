package com.proyecto.ntt.RegistroPaciente.controllers;

import com.proyecto.ntt.RegistroPaciente.dtos.PacienteCrear;
import com.proyecto.ntt.RegistroPaciente.services.PacienteService;
import lombok.extern.log4j.Log4j2;
import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //anotaciones
@RequestMapping("/paciente")
@CrossOrigin("*")
@Log4j2
public class PacienteController {
    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody PacienteCrear dataEntrante) {
        return service.crearPaciente(dataEntrante);
    }
    @GetMapping("/")
    public ResponseEntity<?> consultarTodos(){
        return service.consultaTodo();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id) throws JSONException {
        return service.borrar(id);
    }

    public ResponseEntity<?> existePaciente(String paciente) {
        return null;
    }
}
