package com.ies.daweb.service;

import com.ies.daweb.persistence.entities.Alumno;
import com.ies.daweb.persistence.repositories.AlumnoRepository;
import com.ies.daweb.service.exceptions.AlumnoException;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    public void deleteById(int id) {
        if (!alumnoRepository.existsById(id)) {
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

    public Alumno createAlumno(Alumno alumno) {
        if (alumno.getName() == null || alumno.getName().trim().isEmpty()) {
            throw new AlumnoException("El nombre del alumno no puede estar vacío.");
        }
        if (alumno.getSurname() == null || alumno.getSurname().trim().isEmpty()) {
            throw new AlumnoException("El apellido del alumno no puede estar vacío.");
        }
        if (alumno.getBirth() == null) {
            throw new AlumnoException("La fecha de nacimiento es obligatoria.");
        }
        if (alumno.getBirth().isAfter(LocalDate.now())) {
            throw new AlumnoException("La fecha de nacimiento debe ser anterior a la fecha actual.");
        }
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> findById(int idAlumno) {
        if (this.alumnoRepository.existsById(idAlumno)) {
            return this.alumnoRepository.findById(idAlumno);
        }else {
            throw new AlumnoNotFoundException("No se encuentra el alumno asignado");
        }
    }

    public List<Alumno> findByName(String name){
        List<Alumno> alumnos = this.alumnoRepository.findByName(name);
        if(alumnos.isEmpty()){
              throw new AlumnoNotFoundException("No se ha encontrado ningun alumno con este nombre");
        }else{
            return this.alumnoRepository.findByName(name);
        }
    }
}
