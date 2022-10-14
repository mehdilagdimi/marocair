package com.marocair.marocair.model;

public class Admin extends Person {

    public Admin() {

    }

    public Admin(int id, String fullname, String email, String phone, String password) {
        super(id, fullname, email, phone,password);
    }

    public Admin(String fullname, String email, String phone, String password) {
        super(fullname, email, phone,password);
    }
}
