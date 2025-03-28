package com.example.Project_Cuoi_Ky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project_Cuoi_Ky.dto.ResponseData;
import com.example.Project_Cuoi_Ky.dto.userDTO.CreateDTO;
import com.example.Project_Cuoi_Ky.dto.userDTO.DeleteUserDTO;
import com.example.Project_Cuoi_Ky.dto.userDTO.LoginDTO;
import com.example.Project_Cuoi_Ky.dto.userDTO.UpdateUserDTO;
import com.example.Project_Cuoi_Ky.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/api/register-user")
    public ResponseData registerUser(@RequestBody CreateDTO dto) throws Exception{
        try {
            return userService.registerUser(dto);
        } catch (Exception e) {
           return new ResponseData(5, e.getMessage(), null);
        }
        
    }
    @PostMapping("/api/create-user")
    public ResponseData createUser(@RequestBody CreateDTO dto) throws Exception{
        return userService.createUser(dto);
    }

    @PostMapping("/api/login-user")
    public ResponseData loginUser(@RequestBody LoginDTO dto) throws Exception{
        try {
            return userService.loginUser(dto.getEmail(), dto.getPassword());
        } catch (Exception e) {
            return new ResponseData(5, e.getMessage(), null);
        }
       
    }

    @GetMapping("/api/get-all-user")
    public ResponseData getAllUsers(@RequestParam int page, @RequestParam int size){
        return userService.getAllUser(page, size);
    }

    @PutMapping("/api/update-user")
    public ResponseData updateUser(@RequestBody UpdateUserDTO dto){
        return userService.updateUserService(dto);
    }

    @DeleteMapping("api/delete-user")
    public ResponseData deleteUser(@RequestBody DeleteUserDTO dto){
        return userService.deleteProduct(dto.getId());
    }


}
