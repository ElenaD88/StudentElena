package com.example.controller;

import com.example.dto.FlatDto;
import com.example.entity.Flat;
import com.example.service.FlatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FlatController {

    private final FlatService flatService;
    private final ObjectMapper objectMapper;

    @Autowired
    public FlatController(FlatService flatService, ObjectMapper objectMapper) {
        this.flatService = flatService;
        this.objectMapper = objectMapper;
    }

    public void createFlat(FlatDto flatDto) {
        flatService.createFlat(flatDto);
    }

    public FlatDto readFlat(Integer id) {
        return objectMapper.convertValue(flatService.readFlat(id), FlatDto.class);
    }

    public void updateFlat(FlatDto flatDto) {
        flatService.updateFlat(flatDto);
    }

    public void deleteFlat( Integer id) {
        flatService.delete(id);
    }

    public List<Flat> findAllFlat(){
        return flatService.findAll();
    }
}
