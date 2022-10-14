package com.marocair.marocair.controller;

import com.marocair.marocair.dao.ClientDao;

public class ClientController {

    private ClientDao clientDao;
    public ClientController() {
        clientDao = new ClientDao();
    }


}
