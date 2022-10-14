package com.marocair.marocair.model;

public class Client extends Person {
    private int code;
    public Client() {

    }

    public Client(int id, String fullname, String email, String phone, int code, String password) {
        super(id, fullname, email, phone,password);
    }

    public Client(String fullname, String email, String phone, int code, String password) {
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
