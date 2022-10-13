package com.marocair.marocair.dao;

import com.marocair.marocair.base.DaoBuilder;
import com.marocair.marocair.model.ClientModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao extends DaoBuilder {

    public ClientDao(){
        table = "client";
    }

    public boolean isEmailExist(String email) {
        return this.select("*").where("email", "=", email).build().isEmpty();
    }
    public int isClientExist(String email, String passw) {
        int id = -1;
        try{
            ResultSet res = this.select("*").where("email", "=", email).and("password", "=", passw).buildReturn().execute();
            if(res.next()) id = res.getInt("id");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            System.out.println(id == -1 ? "Invalid Credentials" : "Client exist!");
            return id;
        }
    }

    public void addClient() {
//        this.insert()
    }
}
