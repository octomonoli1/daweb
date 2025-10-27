package com.ies.daweb.web;

import com.ies.daweb.persistence.entities.Alumno;
import com.ies.daweb.service.AlumnoService;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @PostMapping("/create")
    public ResponseEntity<?> createAlumno(@RequestBody Alumno alumno) {
        try {
            Alumno nuevoAlumno = alumnoService.createAlumno(alumno);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Alumno creado correctamente con ID: " + nuevoAlumno.getId());
        } catch (AlumnoNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al crear el alumno: " + e.getMessage());
        }
    }
}