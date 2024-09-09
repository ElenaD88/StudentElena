package com.example.service;

import com.example.dto.AnnouncementDto;
import com.example.entity.Announcement;

import java.util.List;

public interface AnnouncementService {

    public void createAnnouncement(AnnouncementDto announcementDto);

    public Announcement readAnnouncement(Integer id);

    public void updateAnnouncement(AnnouncementDto announcementDto);

    public void delete(Integer id);

    public List<Announcement> findAll();
}
