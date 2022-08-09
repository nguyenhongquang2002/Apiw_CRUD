package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {
    List<Class> findAllByName(String name);
    List<Class> findAllByNameContainsIgnoreCase(String name);
    List<Class> findAllByNameAndRoom(String name, String room);
    List<Class> findAllByNameOrderByRoomAsc(String name); //Asc là ít - Desc là nhiều
}
