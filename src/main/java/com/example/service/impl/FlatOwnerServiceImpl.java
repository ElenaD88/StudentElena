package com.example.service.impl;


import com.example.dao.FlatOwnerDao;
import com.example.dto.FlatOwnerDto;
import com.example.entity.FlatOwner;
import com.example.service.FlatOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FlatOwnerServiceImpl implements FlatOwnerService {

    private final FlatOwnerDao flatOwnerDao;

    @Autowired
    public FlatOwnerServiceImpl(FlatOwnerDao flatOwnerDao) {
        this.flatOwnerDao = flatOwnerDao;
    }

    @Override
    public void createFlatOwner(FlatOwnerDto flatOwnerDto) {

        FlatOwner flatOwner = new FlatOwner();
        flatOwner.setId(flatOwnerDto.getId());
        flatOwner.setName(flatOwnerDto.getName());
        flatOwner.setSurname(flatOwnerDto.getSurname());
        flatOwner.setEmail(flatOwnerDto.getEmail());

        flatOwnerDao.save(flatOwner);
    }

    @Override
    public FlatOwner readFlatOwner(Integer id) {

        FlatOwner byId = flatOwnerDao.findById(id);
        return byId;
    }

    @Override
    public void updateFlatOwner(FlatOwnerDto flatOwnerDto) {
        FlatOwner flatowner = flatOwnerDao.findById(flatOwnerDto.getId());

        if (Objects.nonNull(flatowner)) {
            flatowner.setName(flatOwnerDto.getName());
            flatowner.setSurname(flatOwnerDto.getSurname());
            flatowner.setEmail(flatOwnerDto.getEmail());

            flatOwnerDao.save(flatowner);
        }
    }

    @Override
    public void delete(Integer id) {
        flatOwnerDao.delete(id);
    }

    @Override
    public List<FlatOwner> findAll() {
        return flatOwnerDao.findAll();
    }
}
