package com.example.Project_Cuoi_Ky.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Project_Cuoi_Ky.model.AllCode;

public interface AllCodeRepository extends JpaRepository<AllCode, Long>{
    List<AllCode> findByType(String type);
    boolean existsByType(String type);
}
