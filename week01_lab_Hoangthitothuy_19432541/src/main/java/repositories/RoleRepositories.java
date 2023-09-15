package repositories;

import db.ConnectDB;
import models.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RoleRepositories {
    Connection con;


    public  RoleRepositories()
    {
        con= ConnectDB.getInstance().getConnection();
    }

    public ArrayList<Role> getRoles()
    {
        ArrayList<Role> Roles = new ArrayList<Role>();
        try {
            String sql = "select * from Role";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                Roles.add(new Role(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Roles;
    }


}
