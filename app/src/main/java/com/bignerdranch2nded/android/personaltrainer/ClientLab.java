package com.bignerdranch2nded.android.personaltrainer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bignerdranch2nded.android.personaltrainer.database.ClientBaseHelper;
import com.bignerdranch2nded.android.personaltrainer.database.ClientCursorWrapper;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.ClientListTable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jeffrow on 9/5/2016.
 */
public class ClientLab {
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
        ContentValues values = getContentValues(c);
        mDatabase.insert(ClientListTable.NAME, null, values);
    }

    public List<Client> getClients(){
        List<Client> clients = new ArrayList<>();

        ClientCursorWrapper cursor = queryClients(null, null);

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
        ClientCursorWrapper cursor = queryClients(
                ClientListTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
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

    public void updateClient(Client client){
        String uuidString = client.getId().toString();
        ContentValues values = getContentValues(client);

        mDatabase.update(ClientListTable.NAME, values,
                ClientListTable.Cols.UUID + " = ?",
                new String[] {uuidString});
    }

    private static ContentValues getContentValues(Client client){
        ContentValues values = new ContentValues();
        values.put(ClientListTable.Cols.UUID, client.getId().toString());
        values.put(ClientListTable.Cols.CLIENTNAME, client.getName());

        return values;
    }

    private ClientCursorWrapper queryClients(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                ClientListTable.NAME,
                null, //Columns - null selects all columns
                whereClause,
                whereArgs,
                null,   //groupBy
                null,   //having
                null    //orderBy
        );

        return new ClientCursorWrapper(cursor);
    }
}
