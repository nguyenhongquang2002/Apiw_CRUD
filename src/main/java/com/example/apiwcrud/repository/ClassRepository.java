package com.example.apiwcrud.repository;

import com.example.apiwcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAllByName(String name);
    List<User> findAllByNameContainsIgnoreCase(String name);
    List<User> findAllByNameAndEmail(String name, String email);
    List<User> findAllByNameOrderByEmailAsc(String name); //Asc là ít - Desc là nhiều
}
