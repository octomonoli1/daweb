package com.ies.daweb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ies.daweb.persistence.entities.Alumno;
import com.ies.daweb.persistence.repositories.AlumnoRepository;
import com.ies.daweb.service.exceptions.AlumnoException;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return this.alumnoRepository.findAll();
    }

    public Alumno findById(int idAlumno) {
        if (!this.alumnoRepository.existsById(idAlumno)) { //11
            throw new AlumnoNotFoundException("El alumno con id " + idAlumno + " no existe");
        }
        return this.alumnoRepository.findById(idAlumno).get();
    }

    public void deleteById(int id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }


    public Alumno updateMA(Alumno alumno, int idAlumno) {
        if (alumno.getId() != idAlumno) {
            throw new AlumnoException("Los ids no coinciden");
        }
        if (!this.alumnoRepository.existsById(idAlumno)) {
            throw new AlumnoNotFoundException("El alumno con id " + idAlumno + " no existe");
        }
        if (alumno.getFechaNacimiento() != null) {
            throw new AlumnoException("No se puede modificar la fecha de cumpleaños.");
        }

        Alumno alumnoBD = this.findById(idAlumno);
        alumnoBD.setNombre(alumno.getNombre());
        alumnoBD.setApellidos(alumno.getApellidos());


        return this.alumnoRepository.save(alumnoBD);

    }

    public Alumno createAlumno(Alumno alumno) {
        if (alumno.getNombre() == null || alumno.getNombre().trim().isEmpty()) {
            throw new AlumnoException("El nombre del alumno no puede estar vacío.");
        }
        if (alumno.getApellidos() == null || alumno.getApellidos().trim().isEmpty()) {
            throw new AlumnoException("El apellido del alumno no puede estar vacío.");
        }
        if (alumno.getFechaNacimiento() == null) {
            throw new AlumnoException("La fecha de nacimiento es obligatoria.");
        }
        if (alumno.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new AlumnoException("La fecha de nacimiento debe ser anterior a la fecha actual.");
        }

        return this.alumnoRepository.save(alumno);
    }

    public Alumno update(Alumno alumno, int idAlumno) {
        if (alumno.getId() != idAlumno) {
            throw new AlumnoException("Los ids no coinciden");
        }
        if (!this.alumnoRepository.existsById(idAlumno)) {
            throw new AlumnoNotFoundException("El alumno con id " + idAlumno + " no existe");
        }
        if (alumno.getFechaNacimiento() != null) {
            throw new AlumnoException("No se puede modificar la fecha de cumpleaños.");
        }

        Alumno alumnoBD = this.findById(idAlumno);
        alumnoBD.setNombre(alumno.getNombre());
        alumnoBD.setApellidos(alumno.getApellidos());


        return this.alumnoRepository.save(alumnoBD);

    }

    public Alumno create(Alumno alumno) {
        if (alumno.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new AlumnoException("La fecha de Nacimiento debe ser anterior a la de hoy");
        }
        return this.alumnoRepository.save(alumno);
    }


}
