package com.digitech.springrestapi.Exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(Long id){
        super("Could not find employee for " + id);
    }
}
