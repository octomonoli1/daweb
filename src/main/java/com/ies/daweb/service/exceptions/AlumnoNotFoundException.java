package com.ies.daweb.service.exceptions;

public class AlumnoNotFoundException extends RuntimeException {

    static final long serialVersionUID = 1L;

    public AlumnoNotFoundException(String message){
        super(message);
    }
}