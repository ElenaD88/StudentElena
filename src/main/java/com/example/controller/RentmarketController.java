package com.example.controller;

import com.example.dto.RentmarketDto;
import com.example.entity.Rentmarket;
import com.example.service.RentmarketService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RentmarketController {
    private final RentmarketService rentmarketService;
    private final ObjectMapper objectMapper;

    @Autowired
    public RentmarketController(RentmarketService rentmarketService, ObjectMapper objectMapper) {
        this.rentmarketService = rentmarketService;
        this.objectMapper = objectMapper;
    }

    public void createRentmarket(RentmarketDto rentmarketDto) {
        rentmarketService.createRentmarket(rentmarketDto);
    }

    public RentmarketDto readRentmarket(Integer id) {
        return objectMapper.convertValue(rentmarketService.readRentmarket(id), RentmarketDto.class);
    }

    public void updateRentmarket(RentmarketDto rentmarketDto) {
        rentmarketService.updateRentmarket(rentmarketDto);
    }

    public void deleteRentmarket(Integer id) {
        rentmarketService.delete(id);
    }

    public List<Rentmarket> findAllRentmarket() {
        return rentmarketService.findAll();
    }
}
