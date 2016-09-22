package com.bignerdranch2nded.android.personaltrainer.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.bignerdranch2nded.android.personaltrainer.Client;
import com.bignerdranch2nded.android.personaltrainer.Session;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.ClientListTable;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.SessionListTable;

import java.util.Date;
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
        String clientName = getString(getColumnIndex(ClientListTable.Cols.NAME));

        Client client = new Client(UUID.fromString(uuidString));
        client.setName(clientName);

        return client;
    }

    public Session getSession(){
        String uuidSessionString = getString(getColumnIndex(SessionListTable.Cols.SESSIONUUID));
        String uuidClientString = getString(getColumnIndex(SessionListTable.Cols.CLIENTUUID));
        long date = getLong(getColumnIndex(SessionListTable.Cols.DATE));
        String title = getString(getColumnIndex(SessionListTable.Cols.TITLE));
        String description = getString(getColumnIndex(SessionListTable.Cols.DESCRIPTION));
        int isCompleted = getInt(getColumnIndex(SessionListTable.Cols.COMPLETED));

        Session session = new Session(UUID.fromString(uuidSessionString));
        session.setClientId(UUID.fromString(uuidClientString));
        session.setDate(new Date(date));
        session.setTitle(title);
        session.setDescription(description);
        session.setCompleted(isCompleted != 0);

        return session;
    }
}
