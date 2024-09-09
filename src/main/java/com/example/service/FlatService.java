package com.example.service;

import com.example.dto.FlatDto;
import com.example.entity.Flat;

import java.util.List;

public interface FlatService {

    public void createFlat(FlatDto flatDto);

    public Flat readFlat(Integer id);

    public void updateFlat(FlatDto flatDto);

    public void delete(Integer id);

    public List<Flat> findAll();

}
