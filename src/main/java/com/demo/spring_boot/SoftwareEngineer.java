package com.demo.spring_boot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class SoftwareEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techstack;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(Integer id, String name, String techstack) {
        this.id = id;
        this.name = name;
        this.techstack = techstack;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechstack() {
        return techstack;
    }

    public void setTechstack(String techstack) {
        this.techstack = techstack;
    }

    /*
    equals override to check if it is same as current value
    this is current value
    that is next or to be compared value
    */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SoftwareEngineer that = (SoftwareEngineer) o;
        return  Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(techstack, that.techstack);
    }

    //always contains hash method to pass
    @Override
    public int hashCode() {
        return Objects.hash(id, name, techstack);
    }
}
