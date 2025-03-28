package com.example.Project_Cuoi_Ky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project_Cuoi_Ky.dto.ResponseData;
import com.example.Project_Cuoi_Ky.service.AllCodeService;

@RestController
public class AllcodeController {
@Autowired
    private AllCodeService service;

    @GetMapping("/api/get-allCode")
    public ResponseData getAllCodes(@RequestParam String type){
        return service.getListAllCode(type);
    }
}
