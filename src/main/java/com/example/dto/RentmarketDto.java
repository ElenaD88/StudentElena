package com.example.dto;

public class RentmarketDto {

    private Integer id;
    private String name;
    private Integer cost;

    public RentmarketDto() {
    }

    public RentmarketDto(Integer marketingId, String name, Integer cost) {
        this.id = marketingId;
        this.name = name;
        this.cost = cost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
