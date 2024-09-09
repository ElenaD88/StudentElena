package com.example.controller;

import com.example.dto.AnnouncementDto;
import com.example.entity.Announcement;
import com.example.service.AnnouncementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AnnouncementController {
    private final AnnouncementService announcementService;
    private final ObjectMapper objectMapper;

    @Autowired
    public AnnouncementController(AnnouncementService announcementService, ObjectMapper objectMapper) {
        this.announcementService = announcementService;
        this.objectMapper = objectMapper;
    }

    public void createAnnouncement(AnnouncementDto announcementDto) {
        announcementService.createAnnouncement(announcementDto);
    }

    public AnnouncementDto readAnnouncement(Integer id) {
        return objectMapper.convertValue(announcementService.readAnnouncement(id), AnnouncementDto.class);
    }

    public void updateAnnouncement(AnnouncementDto announcementDto) {
        announcementService.updateAnnouncement(announcementDto);
    }

    public void deleteAnnouncement( Integer id) {
        announcementService.delete(id);
    }

    public List<Announcement> findAllAnnouncement(){
        return announcementService.findAll();
    }
}
