package com.example.dao.impl;

import com.example.dao.FlatOwnerDao;
import com.example.entity.FlatOwner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


    @Component
    public class FlatOwnerDaoImpl implements FlatOwnerDao {

        private List<FlatOwner> flatOwners = new ArrayList<>();

        @Override
        public void save(FlatOwner flatowner) {
            flatOwners.add(flatowner);
        }

        @Override
        public FlatOwner findById(Integer id) {
            Optional<FlatOwner> first = flatOwners.stream()
                    .filter(f -> Objects.equals(f.getId(), id))
                    .findFirst();
            return first.orElse(null);
        }

        @Override
        public void delete(Integer id) {
            flatOwners.removeIf(f ->f.getId().equals(id));
        }

        @Override
        public List<FlatOwner> findAll() {
            return flatOwners;
        }
    }


