package com.example.dao.impl;

import com.example.dao.AnnouncementDao;
import com.example.entity.Announcement;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class AnnouncementDaoImpl implements AnnouncementDao {

    private List<Announcement> announcements = new ArrayList<>();

    @Override
    public void save(Announcement announcement) {
        announcements.add(announcement);
    }

    @Override
    public Announcement findById(Integer id) {
        Optional<Announcement> first = announcements.stream()
                .filter(f -> Objects.equals(f.getId(), id))
                .findFirst();
        return first.orElse(null);
    }

    @Override
    public void delete(Integer id) {
        announcements.removeIf(f -> f.getId().equals(id));
    }

    @Override
    public List<Announcement> findAll() {
        return announcements;
    }
}
