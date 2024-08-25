package com.example.util;

import com.example.annotation.Component;
import com.example.annotation.Value;

@Component
public class ParametersHolder {

    @Value("{my.param.db}")
    private String text;

    public String getText() {
        return text;
    }
}
