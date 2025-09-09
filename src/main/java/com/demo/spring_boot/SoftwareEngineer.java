package com.demo.spring_boot;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SoftwareEngineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String techstack;

    @Column(columnDefinition = "TEXT")
    private String learningPath;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(Integer id, String name, String techstack, String learningPath) {
        this.id = id;
        this.name = name;
        this.techstack = techstack;
        this.learningPath = learningPath;
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

    public void setTechstack(String techstack){
        this.techstack = techstack;
    }

    public String getLearningPath() {
        return learningPath;
    }

    public void setLearningPath(String learningPath) {
        this.learningPath = learningPath;
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
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(techstack, that.techstack) && Objects.equals(learningPath, that.learningPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, techstack, learningPath);
    }
}
