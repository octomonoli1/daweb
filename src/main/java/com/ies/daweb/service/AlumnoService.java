package com.ies.daweb.service;

import com.ies.daweb.persistence.entities.Alumno;
import com.ies.daweb.persistence.repositories.AlumnoRepository;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll(){
        return this.alumnoRepository.findAll();
        }

    public void deleteById(int id){
        if(!alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }

    //update Xexu y canijo
    public Alumno update(Alumno alumno, int id) {
        if (alumno.getId() != id) {
            throw new IllegalArgumentException("El ID del alumno no coincide con el ID de la ruta.");
        }

        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }

        return alumnoRepository.save(alumno);
    }

    public List<Alumno> findAll(){
        return this.alumnoRepository.findAll();
        }

    public void deleteById(int id){
        if(!alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }

    //update Xexu y canijo
    public Alumno update(Alumno alumno, int id) {
        if (alumno.getId() != id) {
            throw new IllegalArgumentException("El ID del alumno no coincide con el ID de la ruta.");
        }

        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }

        return alumnoRepository.save(alumno);
    }

}
