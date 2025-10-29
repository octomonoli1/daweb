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
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> create(@RequestBody Alumno alumno) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.alumnoService.createAlumno(alumno));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

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
    	public ResponseEntity<?> create(@RequestBody Alumno alumno) {
            try{
                return ResponseEntity.status(HttpStatus.CREATED).body(this.alumnoService.create(alumno));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }

    	}
    @PutMapping("/{idAlumno}")
    public ResponseEntity<?> updateMA(@PathVariable int idAlumno, @RequestBody Alumno alumno){
        try {
            return ResponseEntity.ok(this.alumnoService.updateMA(alumno, idAlumno));
        }
        catch(AlumnoNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch (AlumnoException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

}
