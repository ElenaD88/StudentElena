package com.example.dao.impl;

import com.example.annotation.Autowire;
import com.example.annotation.Component;
import com.example.dao.DatabaseInterface;
import com.example.util.ParametersHolder;

@Component
public class DataBaseInterfaceImpl implements DatabaseInterface {

    @Autowire
    private ParametersHolder parametersHolder;

    @Override
    public String execute() {
        return parametersHolder.getText();
    }
}
