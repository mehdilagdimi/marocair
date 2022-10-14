package com.marocair.marocair.model;

public class AdminModel extends PersonModel{

    public AdminModel() {

    }

    public AdminModel(int id, String fullname, String email, String phone, String password) {
        super(id, fullname, email, phone,password);
    }

    public AdminModel(String fullname, String email, String phone, String password) {
        super(fullname, email, phone,password);
    }
}
