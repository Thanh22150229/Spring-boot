package com.example.Project_Cuoi_Ky.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project_Cuoi_Ky.dto.DeleteProductDTO;
import com.example.Project_Cuoi_Ky.dto.ProductDTO;
import com.example.Project_Cuoi_Ky.dto.ResponseData;
import com.example.Project_Cuoi_Ky.dto.UpdateProductDTO;
import com.example.Project_Cuoi_Ky.model.ProductEntity;
import com.example.Project_Cuoi_Ky.service.ProductService;

@RestController

public class ProductController {

    @Autowired
	private ProductService productService;
    @PostMapping("/api/create-products")
    public ResponseData createProducts(@RequestBody ProductDTO request) {
        return productService.createProducts(request);
    }

    @GetMapping("/api/get-product-list")
    public ResponseData getAllProducts(@RequestParam int page,@RequestParam int size) {
        return productService.getAllProducts(page,size);
    }

    @DeleteMapping("/api/delete-product")
    public ResponseData deleteProduct(@RequestBody DeleteProductDTO request) {
        if(request.getId() == null){
            return new ResponseData(2, "Id is required",null);
        }else{
            return productService.deleteProduct(request.getId());
        }
        
    }

    @PutMapping("api/update-products")
    public ResponseData updateData(@RequestBody UpdateProductDTO request){
        return productService.updateProduct(request);
    }

    @GetMapping("/api/get-product-by-category")
    public ResponseData getProductByCategory(@RequestParam String category){
        return productService.getProductBycategory(category);
    }

}
