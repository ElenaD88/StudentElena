package com.example.dao;
import com.example.entity.FlatOwner;
import java.util.List;

    public interface FlatOwnerDao {

        void save(FlatOwner user);

        FlatOwner findById(Integer id);

        void delete(Integer id);

        List<FlatOwner> findAll();
    }
