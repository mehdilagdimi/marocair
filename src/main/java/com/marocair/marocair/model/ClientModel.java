package com.marocair.marocair.model;

public class ClientModel extends PersonModel{
    private int code;
    public ClientModel() {

    }

    public ClientModel(int id, String fullname, String email, String phone, int code, String password) {
        super(id, fullname, email, phone,password);
    }

    public ClientModel(String fullname, String email, String phone, int code, String password) {
        super(fullname, email, phone,password);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
