package com.marocair.marocair.dao;

import com.marocair.marocair.base.DaoBuilder;
import com.marocair.marocair.model.Admin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends DaoBuilder {

    public AdminDao (){
        table = "admin";
    }


    boolean isEmailExist(String email, String passw) {
        return this.select("*").where("email", "=", email).build().isEmpty();
    }
    public Admin isAdminExist(String email, String password) {
        Admin admin = new Admin();
        try{
            ResultSet res = this.select("*").where("email", "=", email).and("password", "=", password).build().execute();
            while (res.next()){
                admin.setId(res.getInt("id"));
                admin.setFullname(res.getString("fullname"));
                admin.setEmail(res.getString("email"));
            }
            return admin;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
