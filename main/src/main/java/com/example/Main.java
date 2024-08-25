package com.example;

import com.example.container.IocContainer;
import com.example.controller.FirstController;

public class Main {
    public static void main(String[] args) {
        IocContainer container = new IocContainer("com.example");

        FirstController controller = container.getBean(FirstController.class);
        String execute = controller.execute();
        System.out.println(execute);
    }
}
