package com.marocair.marocair.model;

public class AdminModel extends PersonModel{
    private String password;

    public AdminModel() {

    }

    public AdminModel(String password) {
        this.password = password;
    }

    public AdminModel(int id, String fullname, String email, String phone, String password) {
        super(id, fullname, email, phone);
        this.password = password;
    }

    public AdminModel(String fullname, String email, String phone, String password) {
        super(fullname, email, phone);
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
