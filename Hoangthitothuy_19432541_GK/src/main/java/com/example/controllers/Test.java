package com.example.controllers;

import com.example.entities.Manager;
import com.example.services.ManagerService;

public class Test {
    public static void main(String[] args) {
        ManagerService managerService = new ManagerService();
        Manager manager = new Manager(1,"Hoàng Tố Thùy","Junior");
        manager.setMa_id(5);

    }
}
