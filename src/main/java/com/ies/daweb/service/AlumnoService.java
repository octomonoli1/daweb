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
        return alumnoRepository.findAll();
    }

    public void deleteById(int id) {
        if (!alumnoRepository.existsById(id)) {
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
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

    public Alumno findById(int id){
        if(!this.alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException("El id " + id + "no pertenece a ningun alumno");
        }
       return this.alumnoRepository.findById(id).get();
    }
    public List<Alumno> findByName(String nombre) {
        if (!this.alumnoRepository.existsByNombre(nombre)) {
            throw new AlumnoNotFoundException("El nombre del alumno que has introducido no se encuentra");
        }
        return this.alumnoRepository.findByName(nombre);
    }

}
