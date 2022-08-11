package com.example.apiwcrud.service;

import com.example.apiwcrud.model.Class;
import com.example.apiwcrud.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceimpl implements ClassService {
    @Autowired

    ClassRepository classRepository;

    @Override
    public void saveClass(Class c) {
        classRepository.save(c);
    }

    @Override
    public void deleteClass(Integer id) {
        classRepository.deleteById(id);
    }

    @Override
    public Class findById(Integer id) {
        return classRepository.findById(id).get();
    }

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }

    public List<Class> findAllByName(String name){
        return classRepository.findAllByName(name);
    }
}
