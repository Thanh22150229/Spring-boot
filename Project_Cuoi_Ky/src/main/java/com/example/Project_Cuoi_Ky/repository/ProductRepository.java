package com.example.Project_Cuoi_Ky.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Project_Cuoi_Ky.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
   @Query("SELECT p FROM ProductEntity p")
   Page<ProductEntity> findAllProductsWithPagination(Pageable pageable);
   List<ProductEntity> findByCategory(String category);
}
