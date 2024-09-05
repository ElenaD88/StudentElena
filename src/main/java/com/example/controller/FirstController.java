package com.example.controller;

import com.example.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FirstController {

    private final  ServiceInterface serviceInterface;

    @Autowired
    public FirstController(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public FirstController(){
        this.serviceInterface = null;
    }

    public String execute(){
       return serviceInterface.execute();
    }
}
