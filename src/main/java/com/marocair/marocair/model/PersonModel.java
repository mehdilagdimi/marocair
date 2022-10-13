package com.marocair.marocair.model;

public class PersonModel {
    private int id;
    private String fullname;
    private String email;
    private String phone;

    public PersonModel() {

    }

    public PersonModel(int id, String fullname, String email, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
    }

    public PersonModel(String fullname, String email, String phone) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
