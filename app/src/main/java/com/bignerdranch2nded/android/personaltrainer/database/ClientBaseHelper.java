package com.bignerdranch2nded.android.personaltrainer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.ClientListTable;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.SessionListTable;

/**
 * Created by Jeffrow on 9/12/2016.
 */
public class ClientBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "clientBase.db";

    public ClientBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + ClientListTable.CLIENT_NAME + "(" +
                " _id integer primary key autoincrement, " +
                ClientListTable.Cols.UUID + ", " +
                ClientListTable.Cols.NAME + ")"
        );

        db.execSQL("create table " + SessionListTable.SESSION_NAME + "(" +
                " _id integer primary key autoincrement, " +
                SessionListTable.Cols.SESSIONUUID + ", " +
                SessionListTable.Cols.CLIENTUUID + ", " +
                SessionListTable.Cols.DATE + ", " +
                SessionListTable.Cols.TITLE + ", " +
                SessionListTable.Cols.DESCRIPTION + ", " +
                SessionListTable.Cols.COMPLETED + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
