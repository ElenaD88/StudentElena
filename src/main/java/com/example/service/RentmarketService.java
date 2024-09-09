package com.example.service;

import com.example.dto.RentmarketDto;
import com.example.entity.Rentmarket;

import java.util.List;

public interface RentmarketService {

    public void createRentmarket(RentmarketDto RentmarketDto);

    public Rentmarket readRentmarket(Integer id);

    public void updateRentmarket(RentmarketDto rentmarketDto);

    public void delete(Integer id);

    public List<Rentmarket> findAll();
}
