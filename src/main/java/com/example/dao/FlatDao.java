package com.example.dao;

import com.example.entity.Flat;

import java.util.List;

public interface FlatDao {

    void save(Flat user);

    Flat findById(Integer id);

    void delete(Integer id);

    List<Flat> findAll();
}
