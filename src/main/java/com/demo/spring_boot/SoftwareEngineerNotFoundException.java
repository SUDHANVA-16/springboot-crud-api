package com.demo.spring_boot;

public class SoftwareEngineerNotFoundException extends RuntimeException {
    public SoftwareEngineerNotFoundException(Integer id) {
        super("Software Engineer not found with id: " + id);
    }
}
