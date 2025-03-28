package com.example.Project_Cuoi_Ky.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Project_Cuoi_Ky.model.ProductEntity;
import com.example.Project_Cuoi_Ky.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
  
    Page<User> findAll(Pageable pageable);
    User findByEmail(String email);
    boolean existsByEmail(String email);
}

