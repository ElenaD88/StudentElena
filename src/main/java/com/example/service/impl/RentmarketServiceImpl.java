package com.example.service.impl;

import com.example.dao.RentmarketDao;
import com.example.dto.RentmarketDto;
import com.example.entity.Rentmarket;
import com.example.service.RentmarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RentmarketServiceImpl implements RentmarketService {

    private final RentmarketDao rentmarketDao;

    @Autowired
    public RentmarketServiceImpl(RentmarketDao rentmarketDao) {
        this.rentmarketDao = rentmarketDao;
    }

    @Override
    public void createRentmarket(RentmarketDto rentmarketDto) {

        Rentmarket rentmarket = new Rentmarket();
        rentmarket.setId(rentmarketDto.getId());
        rentmarket.setName(rentmarketDto.getName());
        rentmarket.setCost(rentmarketDto.getCost());

        rentmarketDao.save(rentmarket);
    }

    @Override
    public Rentmarket readRentmarket(Integer id) {

        Rentmarket byId = rentmarketDao.findById(id);
        return byId;
    }

    @Override
    public void updateRentmarket(RentmarketDto rentmarketDto) {
        Rentmarket rentmarket = rentmarketDao.findById(rentmarketDto.getId());

        if (Objects.nonNull(rentmarket)) {
            rentmarket.setId(rentmarketDto.getId());
            rentmarket.setName(rentmarketDto.getName());
            rentmarket.setCost(rentmarketDto.getCost());

            rentmarketDao.save(rentmarket);
        }
    }

    @Override
    public void delete(Integer id) {
        rentmarketDao.delete(id);
    }

    @Override
    public List<Rentmarket> findAll() {
        return rentmarketDao.findAll();
    }
}

