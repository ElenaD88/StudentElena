package com.example.dao.impl;

import com.example.dao.RentmarketDao;
import com.example.entity.Rentmarket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
    public class RentmarketDaoImpl implements RentmarketDao {

        private List<Rentmarket> rentmarkets = new ArrayList<>();

        @Override
        public void save(Rentmarket rentmarket) {
            rentmarkets.add(rentmarket);
        }

        @Override
        public Rentmarket findById(Integer id) {
            Optional<Rentmarket> first = rentmarkets.stream()
                    .filter(f -> Objects.equals(f.getId(), id))
                    .findFirst();
            return first.orElse(null);
        }

        @Override
        public void delete(Integer id) {
            rentmarkets.removeIf(f ->f.getId().equals(id));
        }

        @Override
        public List<Rentmarket> findAll() {
            return rentmarkets;
        }
    }


