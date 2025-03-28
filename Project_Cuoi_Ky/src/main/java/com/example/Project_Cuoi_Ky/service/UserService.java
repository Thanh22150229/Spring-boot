package com.example.Project_Cuoi_Ky.service;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.Project_Cuoi_Ky.dto.ResponseData;
import com.example.Project_Cuoi_Ky.dto.userDTO.CreateDTO;
import com.example.Project_Cuoi_Ky.dto.userDTO.UpdateUserDTO;
import com.example.Project_Cuoi_Ky.dto.userDTO.UserOutputDTO;
import com.example.Project_Cuoi_Ky.model.ProductEntity;
import com.example.Project_Cuoi_Ky.model.User;
import com.example.Project_Cuoi_Ky.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public ResponseData createUser(CreateDTO request) throws Exception {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(hashText(request.getPassword()));
        user.setPhoneNumber(request.getPhoneNumber());
        user.setRoleId(request.getRoleId());
        userRepository.save(user);
        ResponseData res = new ResponseData(0, "Success", null);
        return res;
    }

    public String hashText(String password) throws Exception {
        String plainText = password;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(plainText.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

   

    public ResponseData getAllUser(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);

        Page<User> userPage = userRepository.findAll(pageRequest);

        List<UserOutputDTO> usersDTO = userPage.stream()
                .map(user -> new UserOutputDTO(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(),
                        user.getPhoneNumber(), user.getRoleId()))
                .toList();
        long totalProducts = userRepository.count();
        int totalPages = (int) Math.ceil((double) totalProducts / size);

        Map<String, Object> responseData = new HashMap<>();
        responseData.put("data", usersDTO);
        responseData.put("totalPages", totalPages);

        ResponseData res = new ResponseData(0, "Success", responseData);
        return res;
    }

    public ResponseData registerUser(CreateDTO request) throws Exception {
        if (request.getEmail() == null || request.getPassword() == null) {
            return new ResponseData(5, "Email and Password are required", null);
        } else {
            boolean check = checkEmail(request.getEmail());
            if (check) {
                return new ResponseData(1, "Email is already in use", null);
            }
            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setLastName(request.getLastName());
            user.setEmail(request.getEmail());
            user.setPassword(hashText(request.getPassword()));
            user.setPhoneNumber(request.getPhoneNumber());
            user.setRoleId(request.getRoleId());
            userRepository.save(user);
            ResponseData res = new ResponseData(0, "Register Success", null);
            return res;
        }

    }

    public ResponseData loginUser(String email, String password) throws Exception {
        ResponseData res = null;
        if (email == null || password == null) {
            res = new ResponseData(4, "Missing parameter", null);
            return res;
        } else {
            boolean check = checkEmail(email);
            if (check == true) {
                User user = userRepository.findByEmail(email);
                if (user.getPassword().equals(hashText(password))) {
                    UserOutputDTO dto = new UserOutputDTO(user.getId(), user.getEmail(), user.getFirstName(),
                            user.getLastName(), user.getPhoneNumber(), user.getRoleId());
                    res = new ResponseData(0, "Login success", dto);
                } else {
                    res = new ResponseData(1, "Password wrong", null);
                }
            } else {
                res = new ResponseData(3, "Email wrong", null);
            }
            return res;
        }
    }

    public boolean checkEmail(String email) {
        boolean checkEmail = userRepository.existsByEmail(email);
        if (checkEmail) {
            return true;
        } else {
            return false;
        }
    }

    public ResponseData updateUserService(UpdateUserDTO dto) {

        if (userRepository.existsById(dto.getId())) {
            User user = userRepository.findById(dto.getId()).get();
            user.setFirstName(dto.getFirstName());
            user.setLastName(dto.getLastName());
            user.setPhoneNumber(dto.getPhoneNumber());
            user.setEmail(dto.getEmail());
            user.setRoleId(dto.getRoleId());
            userRepository.save(user);

            return new ResponseData(0, "Update success", null);
        } else {

            return new ResponseData(1, "Id not found", null);
        }
    }

    public ResponseData deleteProduct(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ResponseData(0, "Success", null);
        } else {
            return new ResponseData(1, "Id not found", null);
        }
    }
}
