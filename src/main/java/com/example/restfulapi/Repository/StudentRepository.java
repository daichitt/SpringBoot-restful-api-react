package com.example.restfulapi.Repository;

import com.example.restfulapi.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository extends JpaRepository<Student, Long> {
}
