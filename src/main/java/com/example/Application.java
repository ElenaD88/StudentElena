package com.example;

import com.example.config.AppConfig;
import com.example.controller.AnnouncementController;
import com.example.controller.FlatController;
import com.example.controller.FlatOwnerController;
import com.example.controller.RentmarketController;
import com.example.dto.AnnouncementDto;
import com.example.dto.FlatDto;
import com.example.dto.FlatOwnerDto;
import com.example.dto.RentmarketDto;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        FlatController flatController = context.getBean(FlatController.class);
        FlatOwnerController flatOwnerController = context.getBean(FlatOwnerController.class);
        AnnouncementController announcementController = context.getBean(AnnouncementController.class);
        RentmarketController rentmarketController = context.getBean(RentmarketController.class);

        // Flat
        FlatDto flatDto1 = new FlatDto(1, "www", "rrr", "tttt", 3, Timestamp.valueOf("2000-01-01 00:00:00"));
        FlatDto flatDto2 = new FlatDto(2, "www2", "rrr2", "tttt2", 2, Timestamp.valueOf("2020-01-01 00:00:00"));

        flatController.createFlat(flatDto1);
        flatController.createFlat(flatDto2);
        System.out.println("flat1 " + flatController.readFlat(1));

        System.out.println("all flats");
        flatController.findAllFlat().forEach(f -> System.out.println(f.getId()));

        flatController.deleteFlat(2);

        System.out.println("all flats after deleting");
        flatController.findAllFlat().forEach(System.out::println);

        flatDto1.setAddress("Гоголя");
        flatController.updateFlat(flatDto1);
        System.out.println("new flat1 " + flatController.readFlat(1));

        //FlatOwner
        FlatOwnerDto flatOwnerDto1 = new FlatOwnerDto(1, "Ivan", "Petrov", "IvanPetrov");
        FlatOwnerDto flatOwnerDto2 = new FlatOwnerDto(2, "Olga", "Ivanova", "OlgaIvanova ");

        flatOwnerController.createFlatOwner(flatOwnerDto1);
        flatOwnerController.createFlatOwner(flatOwnerDto2);
        System.out.println("flatowner 1 " + flatOwnerController.readFlatOwner(1));

        System.out.println("all flatowners");
        flatOwnerController.findAllFlatOwner().forEach(f -> System.out.println(f.getId()));

        flatOwnerController.deleteFlatOwner(2);

        System.out.println("all flatowners after deleting");
        flatOwnerController.findAllFlatOwner().forEach(System.out::println);

        flatOwnerDto1.setName("Sergey");
        flatOwnerController.updateFlatOwner(flatOwnerDto1);
        System.out.println("new flatowner1 " + flatOwnerController.readFlatOwner(1));

        //Announcement

        AnnouncementDto announcementDto1 = new AnnouncementDto(1, 200, 1, 2);
        AnnouncementDto announcementDto2 = new AnnouncementDto(2, 150, 2, 2);

        announcementController.createAnnouncement(announcementDto1);
        announcementController.createAnnouncement(announcementDto2);
        System.out.println("announcement 1 " + announcementController.readAnnouncement(1));

        System.out.println("all announcements");
        announcementController.findAllAnnouncement().forEach(f -> System.out.println(f.getId()));

        announcementController.deleteAnnouncement(2);

        System.out.println("all announcements after deleting");
        announcementController.findAllAnnouncement().forEach(System.out::println);

        announcementDto1.setPrice(300);
        announcementController.updateAnnouncement(announcementDto1);
        System.out.println("new announcement1 " + announcementController.readAnnouncement(1));

        //Rentmarket
        RentmarketDto rentmarketDto1 = new RentmarketDto(1, "ИЗ рук в руки", 15);
        RentmarketDto rentmarketDto2 = new RentmarketDto(2, "Куфар", 20);

        rentmarketController.createRentmarket(rentmarketDto1);
        rentmarketController.createRentmarket(rentmarketDto2);
        System.out.println("rentmarket 1 " + rentmarketController.readRentmarket(1));

        System.out.println("all rentmarkets");
        rentmarketController.findAllRentmarket().forEach(f -> System.out.println(f.getId()));

        rentmarketController.deleteRentmarket(2);

        System.out.println("all rentmarkets after deleting");
        rentmarketController.findAllRentmarket().forEach(System.out::println);

        rentmarketDto1.setName("Онлайнер");
        rentmarketController.updateRentmarket(rentmarketDto1);
        System.out.println("new rentmarket 1 " + rentmarketController.readRentmarket(1));
    }
}
