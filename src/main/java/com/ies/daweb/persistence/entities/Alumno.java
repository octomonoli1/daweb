package com.ies.daweb.persistence.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "alumnos")
@Getter
@Setter
@NoArgsConstructor
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="name")
    private String nombre;
    
    @Column(name="surname")
    private String apellidos;
    
    @Column(name="birth")
    private LocalDate fechaNacimiento;
}
