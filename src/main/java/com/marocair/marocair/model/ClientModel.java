package com.marocair.marocair.model;

public class ClientModel extends PersonModel{
    private int code;
    private String password;

    public ClientModel() {

    }

    public ClientModel(int id, String fullname, String email, String phone, int code, String password) {
        super(id, fullname, email, phone);
        this.code = code;
        this.password = password;
    }

    public ClientModel(String fullname, String email, String phone, int code, String password) {
        super(fullname, email, phone);
        this.code = code;
        this.password = password;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
