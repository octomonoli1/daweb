package com.ies.daweb.persistence.repositories;

import com.ies.daweb.persistence.entities.Alumno;
import org.springframework.data.repository.ListCrudRepository;

public interface AlumnoRepository extends ListCrudRepository<Alumno,Integer> {
}
