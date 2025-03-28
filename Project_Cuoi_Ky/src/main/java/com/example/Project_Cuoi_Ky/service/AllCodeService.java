package com.example.Project_Cuoi_Ky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project_Cuoi_Ky.dto.ResponseData;
import com.example.Project_Cuoi_Ky.model.AllCode;
import com.example.Project_Cuoi_Ky.repository.AllCodeRepository;

@Service
public class AllCodeService {
@Autowired
AllCodeRepository allCodeRepository;

public ResponseData getListAllCode(String type) {
    ResponseData res;
    if (allCodeRepository.existsByType(type)) {
        List<AllCode> codes = allCodeRepository.findByType(type);
    
        res = new ResponseData(0, "Success", codes);
    } else {
        res = new ResponseData(1, "Type not found", null);
    }
    return res;
}



}
