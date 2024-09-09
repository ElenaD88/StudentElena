package com.example.dto;

import java.sql.Timestamp;

public class FlatDto {
    private Integer id;
    private String description;
    private String houseLocation;
    private String address;
    private Integer roomsAmount;
    private Timestamp timeBuilt;

    public FlatDto() {
    }

    public FlatDto(Integer id, String description, String houseLocation, String address, Integer roomsAmount, Timestamp timeBuilt) {
        this.id = id;
        this.description = description;
        this.houseLocation = houseLocation;
        this.address = address;
        this.roomsAmount = roomsAmount;
        this.timeBuilt = timeBuilt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoomsAmount() {
        return roomsAmount;
    }

    public void setRoomsAmount(Integer roomsAmount) {
        this.roomsAmount = roomsAmount;
    }

    public Timestamp getTimeBuilt() {
        return timeBuilt;
    }

    public void setTimeBuilt(Timestamp timeBuilt) {
        this.timeBuilt = timeBuilt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
