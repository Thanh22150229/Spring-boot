package com.example.Project_Cuoi_Ky.dto.userDTO;

public class CreateDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;
    private String roleId;
    
    public CreateDTO() {
    }
    
    public CreateDTO( String firstName, String lastName, String email, String password, int phoneNumber, String roleId) {
     
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
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
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
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
