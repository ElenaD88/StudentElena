package com.example.controller;

import com.example.dto.FlatOwnerDto;
import com.example.entity.FlatOwner;
import com.example.service.FlatOwnerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FlatOwnerController {

    private final FlatOwnerService flatOwnerService;
    private final ObjectMapper objectMapper;

    @Autowired
    public FlatOwnerController(FlatOwnerService flatOwnerService, ObjectMapper objectMapper) {
        this.flatOwnerService = flatOwnerService;
        this.objectMapper = objectMapper;
    }

    public void createFlatOwner(FlatOwnerDto flatOwnerDto) {
        flatOwnerService.createFlatOwner(flatOwnerDto);
    }

    public FlatOwnerDto readFlatOwner(Integer id) {
        return objectMapper.convertValue(flatOwnerService.readFlatOwner(id), FlatOwnerDto.class);
    }

    public void updateFlatOwner(FlatOwnerDto flatOwnerDto) {
        flatOwnerService.updateFlatOwner(flatOwnerDto);
    }

    public void deleteFlatOwner(Integer id) {
        flatOwnerService.delete(id);
    }
    public List<FlatOwner> findAllFlatOwner() { return flatOwnerService.findAll();}
}