package com.ies.daweb.service;

import com.ies.daweb.persistence.repositories.AlumnoRepository;
import com.ies.daweb.service.exceptions.AlumnoNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {

    @Mock
    private AlumnoRepository alumnoRepository;

    @InjectMocks
    private AlumnoService alumnoService;

    private int id;

    @BeforeEach
    void setUp(){
        //Given
        this.id = 2;
    }

    @Test
    void delete_alumno_by_id_exito(){
        //Given
        when(alumnoRepository.existsById(id)).thenReturn(true);

        //When
        alumnoService.deleteById(this.id);

        //Then
        verify(alumnoRepository).deleteById(this.id);
    }

    @Test
    void delete_alumno_by_id_fail(){
        //Given
        when(alumnoRepository.existsById(id)).thenReturn(false);

        //When - Then
        RuntimeException exception = assertThrows(AlumnoNotFoundException.class, () -> {
            alumnoService.deleteById(this.id);
        });
    }
}
