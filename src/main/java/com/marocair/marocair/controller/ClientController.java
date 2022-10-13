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
        int id = clientDao.isClientExist(email, passw);
        if(id == -1){
            return null;
        }
        ClientModel clientModel = new ClientModel();
        clientModel.setId(id);
        clientModel.setEmail(email);
        clientModel.setPassw(passw);
        return clientModel;
    }

}
