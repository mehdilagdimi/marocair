package com.marocair.marocair.dao;

import com.marocair.marocair.base.DaoBuilder;
import com.marocair.marocair.model.Client;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDao extends DaoBuilder {

    public ClientDao(){
        table = "client";
    }

    public Client isClientExist(String email, String password) {
        Client client = new Client();
        try{
            ResultSet res = this.select("*").where("email", "=", email).and("password", "=", password).build().execute();
            while (res.next()){
                client.setId(res.getInt("id"));
                client.setFullname(res.getString("fullname"));
                client.setEmail(res.getString("email"));
            }
            return client;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
