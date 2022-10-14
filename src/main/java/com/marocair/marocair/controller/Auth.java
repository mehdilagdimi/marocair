package com.marocair.marocair.controller;

import com.marocair.marocair.dao.AdminDao;
import com.marocair.marocair.dao.ClientDao;
import com.marocair.marocair.model.Person;
import jakarta.servlet.http.HttpSession;

public class Auth {
    public static boolean authenticate(Person guest, HttpSession session){
        String instanceOf = guest.getClass().getSimpleName();

        String role = null;
        Person person = null;

        if (instanceOf.equals("Client")) {
            ClientDao clientDao = new ClientDao();
            person = clientDao.isClientExist(guest.getEmail(),guest.getPassword());
            if (person == null) return false;
            role = "client";
        }

        if (instanceOf.equals("Admin")){
            AdminDao adminDao = new AdminDao();
            person = adminDao.isAdminExist(guest.getEmail(),guest.getPassword());
            if (person == null) return false;
            role = "admin";
        }

        session.setAttribute("role",role);
        session.setAttribute("person",person);
        return true;
    }


    public static Person auth(HttpSession session){
        if (session.getAttribute("person") == null) {
            return null;
        }
        return (Person) session.getAttribute("person");
    }

    public static Person auth(HttpSession session, String role){
        Person person = auth(session);
        if (person == null) return null;
        if (!session.getAttribute("role").equals(role)) return null;
        return person;
    }
}
