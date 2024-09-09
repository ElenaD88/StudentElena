package com.example.entity;

import java.sql.Timestamp;

public class Flat {

    private Integer id;
    private String description;
    private String houseLocation;
    private String address;
    private Integer roomsAmount;
    private Timestamp timeBuilt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", houseLocation='" + houseLocation + '\'' +
                ", address='" + address + '\'' +
                ", roomsAmount=" + roomsAmount +
                ", timeBuilt=" + timeBuilt +
                '}';
    }
}
