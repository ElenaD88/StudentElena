package com.example.service.impl;

import com.example.annotation.Autowire;
import com.example.annotation.Component;
import com.example.dao.DatabaseInterface;
import com.example.service.ServiceInterface;

@Component
public class ServiceInterfaceImpl implements ServiceInterface {

    private DatabaseInterface database;

    @Autowire
    public void setDatabaseInterface(DatabaseInterface database){
        this.database = database;
    }

    @Override
    public String execute() {
        return database.execute();
    }
}
