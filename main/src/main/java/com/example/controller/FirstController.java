package com.example.controller;

import com.example.annotation.Autowire;
import com.example.annotation.Component;
import com.example.service.ServiceInterface;

@Component
public class FirstController {

    private final  ServiceInterface serviceInterface;

    @Autowire
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
