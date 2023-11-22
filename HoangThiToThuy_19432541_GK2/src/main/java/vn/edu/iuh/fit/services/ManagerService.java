package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Employee;
import vn.edu.iuh.fit.entities.Manager;
import vn.edu.iuh.fit.reposirories.EmployeeRepo;
import vn.edu.iuh.fit.reposirories.ManagerRepo;

import java.util.List;
import java.util.Optional;

public class ManagerService {
    private ManagerRepo managerRepo;
    public ManagerService(){
        this.managerRepo = new ManagerRepo();
    }
    public void insertManager(Manager manager){
        managerRepo.setup();
        managerRepo.insertManager(manager);
    }
   public Manager findManagerById (int id){
        managerRepo.setup();
        return managerRepo.findManagerById(id);
   }
    public List<Manager> getAll(){
        managerRepo.setup();
        return managerRepo.listManager();
    }

}
