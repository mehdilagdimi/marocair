package com.marocair.marocair.controller;

import com.marocair.marocair.dao.ClientDao;
import com.marocair.marocair.model.ClientModel;

public class ClientController {

    private ClientDao clientDao;
    public ClientController() {
        clientDao = new ClientDao();
    }


}
