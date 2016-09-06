package com.bignerdranch2nded.android.personaltrainer;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientLab {
    private static ClientLab sClientLab;

    private List<Client> mClients;

    public static ClientLab get(Context context){
        if(sClientLab == null){
            sClientLab = new ClientLab(context);
        }
        return sClientLab;
    }

    private ClientLab(Context context){
        mClients = new ArrayList<>();
        for(int i = 1; i <= 10; i++){
            Client client = new Client();

            client.setName("Client #" + i);
            mClients.add(client);
        }
    }

    public List<Client> getClients(){
        return mClients;
    }

    public Client getClient(UUID id){
        for(Client client : mClients){
            if(client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }
}
