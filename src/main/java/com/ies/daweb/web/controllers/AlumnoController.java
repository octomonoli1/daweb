package com.ies.daweb.web.controllers;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        try{
            alumnoService.deleteById(id);
            return ResponseEntity.ok("Alumno " + id + " eliminado correctamente.");
        }catch(AlumnoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try{
            return ResponseEntity.ok(this.alumnoService.findById(id));
        }catch (AlumnoNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
