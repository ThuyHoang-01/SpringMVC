package vn.edu.iuh.fit.controllers;

import vn.edu.iuh.fit.entities.Manager;
import vn.edu.iuh.fit.reposirories.ManagerRepo;
import vn.edu.iuh.fit.services.ManagerService;

public class Test {
    public static void main(String[] args) {
        ManagerService managerService = new ManagerService();
        Manager manager = new Manager(1, "Hoàng Tố Thùy", "Junior");
        manager.setMa_id(5);

    }

}
