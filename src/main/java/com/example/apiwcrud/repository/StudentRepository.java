package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);
    List<Student> findAllByNameContainsIgnoreCase(String name);
    List<Student> findAllByNameAndPhone(String name, String phone);
    List<Student> findAllByNameOrderByPhoneAsc(String name); //Asc là ít - Desc là nhiều
}
