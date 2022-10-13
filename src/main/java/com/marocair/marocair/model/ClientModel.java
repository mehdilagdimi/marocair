package com.marocair.marocair.model;

public class ClientModel {

    private int id;

    private String email;
    private String passw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public String getPassw() {
        return passw;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }
}
