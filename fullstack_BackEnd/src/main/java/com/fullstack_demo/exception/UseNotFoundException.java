package com.fullstack_demo.exception;

public class UseNotFoundException extends RuntimeException{
    public UseNotFoundException(Long id){
        super("Could not found the id "+id);
    }
}
