package com.example.dao.impl;

import com.example.dao.DatabaseInterface;
import com.example.util.ParametersHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInterfaceImpl implements DatabaseInterface {

    @Autowired
    private ParametersHolder parametersHolder;

    @Override
    public String execute() {
        return parametersHolder.getText();
    }
}
