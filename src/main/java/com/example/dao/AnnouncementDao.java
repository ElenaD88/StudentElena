package com.example.dao;

import com.example.entity.Announcement;

import java.util.List;


    public interface AnnouncementDao {

        void save(Announcement user);

        Announcement findById(Integer id);

        void delete(Integer id);

        List<Announcement> findAll();
    }

