package db;

import models.Account;
import repositories.AccountRepositories;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        String username="ThuyHoang";
        String password="221";

        AccountRepositories AccRepo = new AccountRepositories();
        Account acc = AccRepo.checkLogin(username,password);
        if(acc ==null)
        {
            System.out.println("wrong password or username !!");
        }else {
            System.out.println(acc.toString());


        }
    }
}
