package com.example.restfulapi.Model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Size;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(min = 1, max = 50, message = "Name must be between 1 and 50 characters")
    private String name;
    @Min(value = 0, message = "Age must be at larger than than 0")
    @Max(value = 120, message = "Age must be at smaller than 120")
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
