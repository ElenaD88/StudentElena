package com.example.entity;

public class Announcement {

    private Integer id;
    private Integer price;
    private Integer flatId;
    private Integer flatOwnerId;

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


    @Override
    public String toString() {
        return "Announcement{" +
                "id=" + id +
                ", price=" + price +
                ", flatId=" + flatId +
                ", flatOwnerId=" + flatOwnerId +
                '}';
    }
}
