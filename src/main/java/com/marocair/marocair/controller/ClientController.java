package com.marocair.marocair.controller;

import com.marocair.marocair.dao.ClientDao;
import com.marocair.marocair.model.ClientModel;

public class ClientController {

    private ClientDao clientDao;
    public ClientController() {
        clientDao = new ClientDao();
    }

    public ClientModel getClient(String email, String passw){
        //validation
        if(!clientDao.isEmailExist(email)){
            return null;
        }
        if(clientDao.isClientExist(email, passw) == -1){
            return null;
        }
        ClientModel clientModel = new ClientModel();
        clientModel.setEmail(email);
        clientModel.setEmail(passw);
        return clientModel;
    }

}
