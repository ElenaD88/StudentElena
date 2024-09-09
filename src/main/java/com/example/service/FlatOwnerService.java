package com.example.service;

import com.example.dto.FlatOwnerDto;
import com.example.entity.FlatOwner;

import java.util.List;

public interface FlatOwnerService {

    public void createFlatOwner(FlatOwnerDto flatOwnerDto);

    public FlatOwner readFlatOwner(Integer id);

    public void updateFlatOwner(FlatOwnerDto flatOwnerDto);

    public void delete(Integer id);

    public List<FlatOwner> findAll();
}
