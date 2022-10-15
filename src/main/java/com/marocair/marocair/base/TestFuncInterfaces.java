package com.marocair.marocair.base;

import com.marocair.marocair.model.ClientModel;

public class TestFuncInterfaces {

    public static void main(String[] args) {

        ClientModel clientModel = new ClientModel();

        //INSERT INTO MODEL USING FUNCTIONAL INTERFACES/LAMBDA EXPRESSIONS
        int id = 1;
        String email = "lagdimi.mehdi@gmail.com";
        String passw = "1234";

        ModelSetFI<ClientModel, Integer> setId = (model, data) -> model.setId(data);
        ModelSetFI<ClientModel, String> setEmail = (model, data) -> model.setEmail(data);
        ModelSetFI<ClientModel, String> setPassw = (model, data) -> model.setPassw(data);

        FIHelper.setIntoModel(clientModel, new ModelSetFI[]{setId, setEmail, setPassw}, id, email, passw);



        ModelGetFI<ClientModel, Integer> getId = (model) -> model.getId();
        ModelGetFI<ClientModel, String> getEmail = (model) -> model.getEmail();
        ModelGetFI<ClientModel, String> getPassw = (model) -> model.getPassw();


        String[] data = FIHelper.getFromModel(clientModel, new ModelGetFI[]{getEmail, getPassw}, String.class);
        Integer[] returnedId = FIHelper.getFromModel(clientModel, new ModelGetFI[]{getId}, Integer.class);

        for(String str : data){
            System.out.println(" elm : " + str);
        }
        for(Integer intData : returnedId){
            System.out.println(" elm int: " + intData);
        }
    }
}
