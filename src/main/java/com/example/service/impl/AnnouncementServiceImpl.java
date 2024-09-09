package com.example.service.impl;

import com.example.dao.AnnouncementDao;
import com.example.dto.AnnouncementDto;
import com.example.entity.Announcement;
import com.example.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementDao announcementDao;

    @Autowired
    public AnnouncementServiceImpl(AnnouncementDao announcementDao) {
        this.announcementDao = announcementDao;
    }

    @Override
    public void createAnnouncement(AnnouncementDto announcementDto) {

        Announcement announcement = new Announcement();
        announcement.setId(announcementDto.getId());
        announcement.setPrice(announcementDto.getPrice());
        announcement.setFlatId(announcementDto.getFlatId());
        announcement.setFlatOwnerId(announcementDto.getFlatOwnerId());

        announcementDao.save(announcement);
    }

    @Override
    public Announcement readAnnouncement(Integer id) {

        Announcement byId = announcementDao.findById(id);
        return byId;
    }

    @Override
    public void updateAnnouncement(AnnouncementDto announcementDto) {
        Announcement announcement = announcementDao.findById(announcementDto.getId());

        if (Objects.nonNull(announcement)) {
            announcement.setPrice(announcementDto.getPrice());
            announcement.setFlatId(announcementDto.getFlatId());
            announcement.setFlatOwnerId(announcementDto.getFlatOwnerId());
            announcementDao.save(announcement);
        }
    }

    @Override
    public void delete(Integer id) {
        announcementDao.delete(id);
    }

    @Override
    public List<Announcement> findAll() {
        return announcementDao.findAll();
    }
}


