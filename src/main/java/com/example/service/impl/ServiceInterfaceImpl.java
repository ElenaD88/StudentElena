package com.example.service.impl;

import com.example.dao.DatabaseInterface;
import com.example.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceInterfaceImpl implements ServiceInterface {

    private DatabaseInterface database;

    @Autowired
    public void setDatabaseInterface(DatabaseInterface database){
        this.database = database;
    }

    @Override
    public String execute() {
        return database.execute();
    }
}
