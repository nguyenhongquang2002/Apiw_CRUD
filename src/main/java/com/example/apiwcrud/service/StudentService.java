package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Student;

import java.util.List;

public interface StudentService {
    public void saveStudent(Student s);
    public void deleteStudent(Integer id);
    public Student findById(Integer id);
    public List<Student> findAll();
    public List<Student> findAllByName(String name);
}
