package com.bignerdranch2nded.android.personaltrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;

import com.bignerdranch2nded.android.personaltrainer.database.ClientBaseHelper;
import com.bignerdranch2nded.android.personaltrainer.database.ClientCursorWrapper;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.ClientListTable;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.SessionListTable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientLab {
    private static final String TAG = "ClientLab";
    private static ClientLab sClientLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static ClientLab get(Context context){
        if(sClientLab == null){
            sClientLab = new ClientLab(context);
        }
        return sClientLab;
    }

    private ClientLab(Context context){
        mContext = context.getApplicationContext(); //
        mDatabase = new ClientBaseHelper(mContext).getWritableDatabase();
    }

    public void addClient(Client c){
        ContentValues values = getClientContentValues(c);
        mDatabase.insert(ClientListTable.CLIENT_NAME, null, values);
    }

    public List<Client> getClients(){
        List<Client> clients = new ArrayList<>();

        ClientCursorWrapper cursor = queryClientInformation(null, null, "client");

        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                clients.add(cursor.getClient());
                cursor.moveToNext();
            }
        } finally{
            cursor.close();
        }
        return clients;
    }

    public Client getClient(UUID id){
        ClientCursorWrapper cursor = queryClientInformation(
                ClientListTable.Cols.UUID + " = ? ",
                new String[]{ id.toString() }, "client"
        );

        try{
            if(cursor.getCount() == 0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getClient();
        }finally {
            cursor.close();
        }
    }

    public File getPhotoFile(Client client){
        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if(externalFilesDir == null){
            return null;
        }

        return new File(externalFilesDir, client.getPhotoFilename());
    }

    public void updateClient(Client client){
        String uuidString = client.getClientId().toString();
        ContentValues values = getClientContentValues(client);

        mDatabase.update(ClientListTable.CLIENT_NAME, values,
                ClientListTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    public void addSession(Session s){
        ContentValues values = getSessionsContentValues(s);
        mDatabase.insert(SessionListTable.SESSION_NAME, null, values);
    }

    public List<Session> getSessions(){
        List<Session> sessions = new ArrayList<>();
        ClientCursorWrapper cursor = queryClientInformation(null, null, "session");
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                sessions.add(cursor.getSession());
                cursor.moveToNext();
            }
        } finally{
            cursor.close();
        }
        return sessions;
    }

    public Session getSession(UUID id){
        ClientCursorWrapper cursor = queryClientInformation(
                SessionListTable.Cols.UUID + " = ? ",
                new String[]{ id.toString() }, "session"
        );

        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getSession();
        } finally{
            cursor.close();
        }
    }

    public void updateSession(Session session){
        String uuidSessionString = session.getSessionId().toString();
        //String uuidClientString = client.getClientId().toString();
        ContentValues values = getSessionsContentValues(session);

        mDatabase.update(SessionListTable.SESSION_NAME, values,
                SessionListTable.Cols.UUID + " = ?",
                new String[]{uuidSessionString});
    }

    private static ContentValues getClientContentValues(Client client){
        ContentValues values = new ContentValues();
        values.put(ClientListTable.Cols.UUID, client.getClientId().toString());
        values.put(ClientListTable.Cols.NAME, client.getName());
        values.put(ClientListTable.Cols.PHOTO, client.getStringBitMap());

        return values;
    }

    private static ContentValues getSessionsContentValues(Session session){
        ContentValues values = new ContentValues();
        values.put(SessionListTable.Cols.UUID, session.getSessionId().toString());
        values.put(SessionListTable.Cols.CLIENT_UUID, session.getClientId().toString());
        values.put(SessionListTable.Cols.DATE, session.getDate().getTime());
        values.put(SessionListTable.Cols.TITLE, session.getTitle());
        values.put(SessionListTable.Cols.DESCRIPTION, session.getDescription());
        values.put(SessionListTable.Cols.COMPLETED, session.isCompleted() ? 1 : 0);

        return values;
    }

    private ClientCursorWrapper queryClientInformation(String whereClause, String[] whereArgs, String tableChoice){
        Cursor cursor = null;
        if(tableChoice == "client"){
            cursor = mDatabase.query(
                    ClientListTable.CLIENT_NAME,
                    null, //Columns - null selects all columns
                    whereClause,
                    whereArgs,
                    null,   //groupBy
                    null,   //having
                    null    //orderBy
            );
        } else if(tableChoice == "session"){
            cursor = mDatabase.query(
                    SessionListTable.SESSION_NAME,
                    null, //Columns - null selects all columns
                    whereClause,
                    whereArgs,
                    null,   //groupBy
                    null,   //having
                    null    //orderBy
            );
        }
        return new ClientCursorWrapper(cursor);
    }
}
