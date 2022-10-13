package com.marocair.marocair.dao;

import com.marocair.marocair.base.DaoBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao extends DaoBuilder {

    public AdminDao (){
        table = "admin";
    }


    boolean isEmailExist(String email, String passw) {
        return this.select("*").where("email", "=", email).build().isEmpty();
    }
    int isAdminExist(String email, String passw) {
        int id = -1;
        try{
            ResultSet res = this.select("*").where("email", "=", email).and("password", "=", passw).buildReturn().execute();
            if(res.next()) id = res.getInt("id");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            System.out.println(id == -1 ? "Invalid Credentials" : "Admin exist!");
            return id;
        }
    }


}
