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

    public List<Alumno> findAll(){
        return this.alumnoRepository.findAll();
        }

    public void deleteById(int id){
        if(!alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException("Alumno con id " + id + " no encontrado.");
        }
        alumnoRepository.deleteById(id);
    }
    
    public Alumno create(Alumno alumno) {
    	if (alumno.getFechaNacimiento().isAfter(LocalDate.now())) {
			throw new AlumnoException("La fecha de Nacimiento debe ser anterior a la de hoy");
		}
    	return this.alumnoRepository.save(alumno);
    }

}
