package com.example.restfulapi.Controller;

import com.example.restfulapi.Model.Student;
import com.example.restfulapi.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated // Enable validation on the controller
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping(value = "/")
    public List<Student> viewStudentList() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/detail/{id}")
    public Student viewStudentById(@PathVariable(value = "id") Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + id + " not found");
        }
        return studentRepository.findById(id).get();
    }

    @PostMapping(value = "/add")
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping(value = "/update/{id}")
    public void updateStudent(@PathVariable(value = "id") Long id, @Valid @RequestBody Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            studentRepository.save(student);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + id + " does not exist.");
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long id) {
        if (studentRepository.existsById(id)) {
            Student student = studentRepository.getById(id);
            studentRepository.delete(student);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with ID " + id + " does not exist.");
        }
    }

    // Handle validation errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}