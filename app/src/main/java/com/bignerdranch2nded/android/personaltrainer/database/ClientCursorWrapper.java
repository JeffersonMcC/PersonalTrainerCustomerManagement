package com.bignerdranch2nded.android.personaltrainer.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch2nded.android.personaltrainer.Client;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.ClientListTable;

import java.util.UUID;

/**
 * Created by Jeffrow on 9/12/2016.
 */
public class ClientCursorWrapper extends CursorWrapper{
    public ClientCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Client getClient(){
        String uuidString = getString(getColumnIndex(ClientListTable.Cols.UUID));
        String clientName = getString(getColumnIndex(ClientListTable.Cols.CLIENTNAME));

        Client client = new Client(UUID.fromString(uuidString));
        client.setName(clientName);

        return client;
    }


}
