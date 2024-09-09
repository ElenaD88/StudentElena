package com.example.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParametersHolder {

    @Value("{my.param.db}")
    private String text;

    public String getText() {
        return text;
    }
}
