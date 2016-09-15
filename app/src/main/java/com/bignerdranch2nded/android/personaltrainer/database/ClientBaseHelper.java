package com.bignerdranch2nded.android.personaltrainer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.ClientListTable;
import com.bignerdranch2nded.android.personaltrainer.database.ClientDbSchema.SessionDateTable;

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
        db.execSQL("create table " + ClientListTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                ClientListTable.Cols.UUID + ", " +
                ClientListTable.Cols.CLIENTNAME + ")"
        );

        db.execSQL("create table " + SessionDateTable.NAME + "(" +
                " _id integer primary key autoincrement, " +
                SessionDateTable.Cols.UUID + ", " +
                SessionDateTable.Cols.SESSIONSDATE +
                SessionDateTable.Cols.SESSIONTITLE +
                SessionDateTable.Cols.SESSIONDESCRIPTION+ ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
