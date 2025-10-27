package com.ies.daweb.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ies.daweb.persistence.entities.Alumno;
import com.ies.daweb.service.AlumnoService;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    
    @GetMapping
    public ResponseEntity<?> findAll(){
        try{
            return ResponseEntity.ok(this.alumnoService.findAll());
        }catch (AlumnoNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteById(@PathVariable int id){
            try{
                alumnoService.deleteById(id);
                return ResponseEntity.ok("Alumno " + id + " eliminado correctamente.");
            }catch(AlumnoNotFoundException e){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }
        
        @PostMapping
    	public ResponseEntity<Alumno> create(@RequestBody Alumno alumno) {

    		return ResponseEntity.status(HttpStatus.CREATED).body(this.alumnoService.create(alumno));

    	}
}
