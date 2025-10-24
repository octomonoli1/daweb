package com.ies.daweb.service;

import com.ies.daweb.persistence.entities.Alumno;
import com.ies.daweb.persistence.repositories.AlumnoRepository;
import com.ies.daweb.service.exceptions.AlumnoException;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno findById(int idAlumno) {
        if(!this.alumnoRepository.existsById(idAlumno)) { //11
            throw new AlumnoNotFoundException("El alumno con id " + idAlumno +" no existe");
        }
        return this.alumnoRepository.findById(idAlumno).get();
    }

    public void deleteById(int id){
        if(!alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }
    public Alumno update(Alumno alumno, int idAlumno) {
        if (alumno.getId() != idAlumno) {
            throw new AlumnoException("Los ids no coinciden");
        }
        if(!this.alumnoRepository.existsById(idAlumno)) {
            throw new AlumnoNotFoundException("El alumno con id " + idAlumno + " no existe");
        }
        if (alumno.getBirth() != null) {
            throw new AlumnoException("No se puede modificar la fecha de cumpleaños.");
        }

        Alumno alumnoBD = this.findById(idAlumno);
        alumnoBD.setName(alumno.getName());
        alumnoBD.setSurname(alumno.getSurname());


        return this.alumnoRepository.save(alumnoBD);

    }

}
