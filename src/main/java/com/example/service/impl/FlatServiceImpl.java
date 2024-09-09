package com.example.service.impl;

import com.example.dao.FlatDao;
import com.example.dto.FlatDto;
import com.example.entity.Flat;
import com.example.service.FlatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class FlatServiceImpl implements FlatService {

    private final FlatDao flatDao;

    @Autowired
    public FlatServiceImpl(FlatDao flatDao) {
        this.flatDao = flatDao;
    }

    @Override
    public void createFlat(FlatDto flatDto) {

        Flat flat = new Flat();
        flat.setId(flatDto.getId());
        flat.setAddress(flatDto.getAddress());
        flat.setDescription(flatDto.getDescription());
        flat.setHouseLocation(flatDto.getHouseLocation());
        flat.setRoomsAmount(flatDto.getRoomsAmount());
        flat.setTimeBuilt(flatDto.getTimeBuilt());

        flatDao.save(flat);
    }

    @Override
    public Flat readFlat(Integer id) {

        Flat byId = flatDao.findById(id);
        return byId;
    }

    @Override
    public void updateFlat(FlatDto flatDto) {
        Flat flat = flatDao.findById(flatDto.getId());

        if (Objects.nonNull(flat)) {
            flat.setAddress(flatDto.getAddress());
            flat.setDescription(flatDto.getDescription());
            flat.setHouseLocation(flatDto.getHouseLocation());
            flat.setRoomsAmount(flatDto.getRoomsAmount());
            flat.setTimeBuilt(flatDto.getTimeBuilt());

            flatDao.save(flat);
        }
    }

    @Override
    public void delete(Integer id) {
        flatDao.delete(id);
    }

    @Override
    public List<Flat> findAll() {
        return flatDao.findAll();
    }
}
