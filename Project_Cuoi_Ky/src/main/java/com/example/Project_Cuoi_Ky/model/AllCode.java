package com.example.Project_Cuoi_Ky.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AllCode {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String type;
private String key_map;
private String value;

public AllCode() {
}
public AllCode(Long id, String type, String key_map, String value) {
    this.id = id;
    this.type = type;
    this.key_map = key_map;
    this.value = value;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getType() {
    return type;
}
public void setType(String type) {
    this.type = type;
}
public String getkey_map() {
    return key_map;
}
public void setkey_map(String key_map) {
    this.key_map = key_map;
}
public String getValue() {
    return value;
}
public void setValue(String value) {
    this.value = value;
}


}
