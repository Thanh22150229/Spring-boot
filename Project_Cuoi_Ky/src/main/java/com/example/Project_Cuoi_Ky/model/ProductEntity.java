package com.example.Project_Cuoi_Ky.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double price;
    private double discount;
    private String category;
    private String brand;
    private String status;

   private String image;
 
   

    public ProductEntity() {
    }

    public ProductEntity(long id, String title, double price, double discount, String image, String category, String brand, String status) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.category = category;
        this.brand = brand;
        this.status = status;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public String getImage() {
        return image;
    }

    public String getCategory() {
        return category;
    }

    public String getBrand() {
        return brand;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
