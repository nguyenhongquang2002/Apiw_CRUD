package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Student;
import com.example.apiwcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceimpl implements StudentService {
    @Autowired

    StudentRepository studentRepository;

    @Override
    public void saveStudent(Student s) {
        studentRepository.save(s);
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public List<Student> findAllByName(String name){
        return studentRepository.findAllByName(name);
    }
}
