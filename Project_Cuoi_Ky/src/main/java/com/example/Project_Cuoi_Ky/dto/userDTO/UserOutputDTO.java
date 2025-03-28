package com.example.Project_Cuoi_Ky.dto.userDTO;

public class UserOutputDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int phoneNumber;
    private String roleId;
    
    public UserOutputDTO() {
    }
    
    public UserOutputDTO( Long id,String email, String firstName, String lastName,   int phoneNumber, String roleId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
      
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public int getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getRoleId() {
        return roleId;
    }
    
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
