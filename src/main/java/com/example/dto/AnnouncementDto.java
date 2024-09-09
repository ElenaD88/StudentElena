package com.example.dto;

public class AnnouncementDto {
    private Integer id;
    private Integer price;
    private Integer flatId;
    private Integer flatOwnerId;

    public AnnouncementDto() {
    }

    public AnnouncementDto(Integer announcementId, Integer price, Integer flatId, Integer flatOwnerId) {
        this.id = announcementId;
        this.price = price;
        this.flatId = flatId;
        this.flatOwnerId = flatOwnerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFlatId() {
        return flatId;
    }

    public void setFlatId(Integer flatId) {
        this.flatId = flatId;
    }

    public Integer getFlatOwnerId() {
        return flatOwnerId;
    }

    public void setFlatOwnerId(Integer flatOwnerId) {
        this.flatOwnerId = flatOwnerId;
    }
}
