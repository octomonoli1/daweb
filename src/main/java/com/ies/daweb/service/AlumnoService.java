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

    public Alumno createAlumno(Alumno alumno) {
        if (alumno.getName() == null || alumno.getName().trim().isEmpty()) {
            throw new AlumnoNotFoundException("El nombre del alumno no puede estar vacío.");
        }
        if (alumno.getSurname() == null || alumno.getSurname().trim().isEmpty()) {
            throw new AlumnoNotFoundException("El apellido del alumno no puede estar vacío.");
        }
        if (alumno.getBirth() == null) {
            throw new AlumnoNotFoundException("La fecha de nacimiento es obligatoria.");
        }

        return alumnoRepository.save(alumno);
    }

  
}