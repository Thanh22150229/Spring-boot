package com.example.Project_Cuoi_Ky.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Project_Cuoi_Ky.dto.DeleteProductDTO;
import com.example.Project_Cuoi_Ky.dto.ProductDTO;
import com.example.Project_Cuoi_Ky.dto.ResponseData;
import com.example.Project_Cuoi_Ky.dto.UpdateProductDTO;
import com.example.Project_Cuoi_Ky.model.ProductEntity;
import com.example.Project_Cuoi_Ky.repository.ProductRepository;

@Service

public class ProductService {
 @Autowired
 private ProductRepository productRepository;
 public ResponseData createProducts(ProductDTO request) {
    ProductEntity product=new ProductEntity();
    product.setTitle(request.getTitle());
    product.setPrice(request.getPrice());
    product.setImage(request.getImage());
    product.setDiscount(request.getDiscount());
    product.setBrand(request.getBrand());
    product.setCategory(request.getCategory());
    product.setStatus(request.getStatus());
    productRepository.save(product);
    ResponseData res = new ResponseData(0,"Success",null);
 return res;
 }

 public ResponseData getAllProducts(int page, int size) {
  PageRequest pageRequest = PageRequest.of(page - 1, size);
    
   Page<ProductEntity> products = productRepository.findAllProductsWithPagination(pageRequest);
   
   long totalProducts = productRepository.count();
   int totalPages = (int) Math.ceil((double) totalProducts / size);  
   
   Map<String, Object> responseData = new HashMap<>();
   //responseData.put("data", products);
   responseData.put("totalPages", totalPages);
   responseData.put("data", products.getContent().stream().map(product -> {
    Map<String, Object> productData = new HashMap<>();
    productData.put("id", product.getId());
    productData.put("image", product.getImage());
    productData.put("title", product.getTitle());
    productData.put("price", product.getPrice());
    productData.put("discount", product.getDiscount());
    productData.put("category", product.getCategory());
    productData.put("brand", product.getBrand());
    productData.put("status", product.getStatus());
    return productData;
}).toList());
   
   // Create and return ResponseData object
   ResponseData res = new ResponseData(0, "Success", responseData);
   return res;
}

 public ResponseData deleteProduct(Long id) {
   if (productRepository.existsById(id)) {
       productRepository.deleteById(id);
       return new ResponseData(0, "Success",null);
   } else {
       return new ResponseData(1, "Id not found",null);
   }
}

public ResponseData updateProduct(UpdateProductDTO request) {
  ResponseData res = null;
  if(productRepository.existsById(request.getId())){
    ProductEntity product=productRepository.findById(request.getId()).orElse(null);
    product.setTitle(request.getTitle());
    product.setPrice(request.getPrice());
    product.setImage(request.getImage());
    product.setDiscount(request.getDiscount());
    product.setBrand(request.getBrand());
    product.setCategory(request.getCategory());
    product.setStatus(request.getStatus());
    productRepository.save(product);
    res = new ResponseData(0, null, product);
    return res;
  }else{
    res = new ResponseData(1, "Id not found", null);
    return res;
  }
  
}

public ResponseData getProductBycategory(String category){
  List<ProductEntity> product = productRepository.findByCategory(category);
  ResponseData res = new ResponseData(0, "success", product);
  return res;
}

}
