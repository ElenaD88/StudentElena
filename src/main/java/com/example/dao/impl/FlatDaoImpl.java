package com.example.dao.impl;

import com.example.dao.FlatDao;
import com.example.entity.Flat;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class FlatDaoImpl implements FlatDao {

    private List<Flat> flats = new ArrayList<>();

    @Override
    public void save(Flat flat) {
        flats.add(flat);
    }

    @Override
    public Flat findById(Integer id) {
        Optional<Flat> first = flats.stream()
                .filter(f -> Objects.equals(f.getId(), id))
                .findFirst();
        return first.orElse(null);
    }

    @Override
    public void delete(Integer id) {
        flats.removeIf(f ->f.getId().equals(id));
    }

    @Override
    public List<Flat> findAll() {
        return flats;
    }
}
