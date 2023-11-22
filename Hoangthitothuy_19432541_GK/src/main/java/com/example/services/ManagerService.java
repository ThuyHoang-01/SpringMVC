package com.example.services;

import com.example.entities.Manager;
import com.example.repositories.ManagerRepository;

import java.util.List;

public class ManagerService {
    private ManagerRepository managerRepository;
    public  ManagerService(){
        this.managerRepository = new ManagerRepository();
    }
    public  void insertManager(Manager manager){
        managerRepository.setup();
        managerRepository.insertManager(manager);
    }
    public Manager findMangerById( int id){
        managerRepository.setup();
        return managerRepository.findById(id);
    }
    public List<Manager> getAll() {
        managerRepository.setup();
        return managerRepository.listManager();
    }
    public void delete(int id) {
        managerRepository.setup();
        managerRepository.deleteById(id);
        System.out.println("Delete Succesful");
    }

}
