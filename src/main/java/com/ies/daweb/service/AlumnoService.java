package com.ies.daweb.service;

import com.ies.daweb.persistence.entities.Alumno;
import com.ies.daweb.persistence.repositories.AlumnoRepository;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public void deleteById(int id){
        if(!alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }

    public Alumno findById(int id){
        if(!this.alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException("El id " + id + "no pertenece a ningun alumno");
        }
       return this.alumnoRepository.findById(id).get();
    }

}
