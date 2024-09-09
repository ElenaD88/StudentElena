package com.example.dao;

import com.example.entity.Rentmarket;

import java.util.List;

public interface RentmarketDao {

        void save(Rentmarket user);

        Rentmarket findById(Integer id);

        void delete(Integer id);

        List<Rentmarket> findAll();

}
